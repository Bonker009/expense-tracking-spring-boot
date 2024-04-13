package org.example.miniprojectspring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/expense")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class ExpenseController {
    @GetMapping
    public String getExpense() {
        return "get all expense";
    }

    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable String id) {
        return id;
    }

    @PostMapping
    public String createExpense() {
        return "Post new expense";
    }

    @PutMapping("/{id}")
    public String updateExpenseById(@PathVariable String id) {
        return "update expense ";
    }

    @DeleteMapping("/{id}")
    public String deleteExpenseById(@PathVariable String id) {
        return "delete expense by id";
    }
}
