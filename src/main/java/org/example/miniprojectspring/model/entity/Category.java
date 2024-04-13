package org.example.miniprojectspring.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private UUID categoryId;
    private String name;
    private String description;
    private UUID userId;
}
