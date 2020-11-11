package com.project.budgetapp.controllers;

import com.project.budgetapp.domain.ICategoryService;
import com.project.budgetapp.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @RequestMapping("list")
    public List<Category> list(){
        return categoryService.list();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Category get(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody final Category category){
        return categoryService.createCategory(category);
    }

    @PostMapping
    @RequestMapping("/change/{id}/{newName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category changeName(@PathVariable(value="id") Long id, @PathVariable(value="newName") String newName) {
        return categoryService.changeName(newName, id);
    }
}
