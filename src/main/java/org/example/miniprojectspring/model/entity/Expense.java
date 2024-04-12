package org.example.miniprojectspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private UUID expenseId;
    private double amount;
    private String description;
    private Date date;
    private UUID userId;
    private UUID categoryId;
}
