package com.project.budgetapp.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.budgetapp.models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_return_selected_account() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/account"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        Account[] accounts = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Account[].class);

        Assertions.assertEquals("2020-11-10", accounts[0].getAccount_created());
        Assertions.assertEquals("macko", accounts[0].getAccount_name());
        Assertions.assertNull(accounts[0].getAccount_deleted());
        Assertions.assertEquals(1, accounts[0].getAccount_id());
    }
}
