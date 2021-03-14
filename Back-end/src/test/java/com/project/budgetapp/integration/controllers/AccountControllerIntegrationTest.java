package com.project.budgetapp.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.budgetapp.errors.ErrorMessage;
import com.project.budgetapp.models.Account;
import com.project.budgetapp.repositories.IAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    IAccountRepository accountRepository;

    @Test
    public void should_return_multiple_selected_accounts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/account")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        Account[] accounts = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Account[].class);

        Assertions.assertEquals("2020-11-10", accounts[0].getAccount_created());
        Assertions.assertEquals("macko", accounts[0].getAccount_name());
        Assertions.assertNull(accounts[0].getAccount_deleted());
        Assertions.assertEquals(1, accounts[0].getAccount_id());

        Assertions.assertEquals("2020-11-10", accounts[1].getAccount_created());
        Assertions.assertEquals("dev account", accounts[1].getAccount_name());
        Assertions.assertNull(accounts[1].getAccount_deleted());
        Assertions.assertEquals(2, accounts[1].getAccount_id());
    }

    @Test
    public void should_return_selected_account() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/account/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        Account account = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Account.class);
        Assertions.assertEquals("2020-11-10", account.getAccount_created());
        Assertions.assertEquals("macko", account.getAccount_name());
        Assertions.assertNull(account.getAccount_deleted());
        Assertions.assertEquals(1, account.getAccount_id());
    }

    @Test
    public void should_return_404_when_invalid_id() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/account/4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        ErrorMessage errorMessage = objectMapper.readValue(response, ErrorMessage.class);
        Assertions.assertEquals(404, errorMessage.getStatusCode());
        Assertions.assertEquals("Account with this id does not exist", errorMessage.getMessage());
        Assertions.assertEquals("uri=/api/account/4", errorMessage.getDescription());
    }

    @Test
    @Transactional
    public void should_create_account() throws Exception {
        Account preparedAccount = new Account();
        preparedAccount.setAccount_name("test name");
        preparedAccount.setAccount_created("1970-01-01");
        String accountStr = objectMapper.writeValueAsString(preparedAccount);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(accountStr))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andReturn();

        Account account = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Account.class);

        Assertions.assertEquals("test name", account.getAccount_name());
        Assertions.assertEquals("1970-01-01", account.getAccount_created());
        Assertions.assertNull(account.getAccount_deleted());
    }

    @Test
    public void should_throw_500_when_invalid_account() throws Exception {
        String invalidAccount = "{\"invalid\": \"invalid\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidAccount))
                .andExpect(MockMvcResultMatchers.status().is(500))
                .andReturn();

        ErrorMessage message = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorMessage.class);
        Assertions.assertEquals(500, message.getStatusCode());
        Assertions.assertEquals("uri=/api/account", message.getDescription());
        Assertions.assertEquals("Validation failed for argument", message.getMessage().substring(0,30));
    }

    @Test
    @Transactional
    public void should_delete_account() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/account/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        Exception exception = Assertions.assertThrows(JpaObjectRetrievalFailureException.class, () -> {
            accountRepository.getOne(1l);
        });

        String expected = "Unable to find com.project.budgetapp.models.Account with id 1; nested exception is javax.persistence.EntityNotFoundException: Unable to find com.project.budgetapp.models.Account with id 1";
        Assertions.assertEquals(expected, exception.getMessage());
    }

    @Test
    public void should_return_500_when_invalid_id() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/account/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(500))
                .andReturn();
        ErrorMessage message = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorMessage.class);

        Assertions.assertEquals("No class com.project.budgetapp.models.Account entity with id 5 exists!", message.getMessage());
        Assertions.assertEquals(500, message.getStatusCode());
        Assertions.assertEquals("uri=/api/account/5", message.getDescription());
    }
}
