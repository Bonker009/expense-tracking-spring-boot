package org.example.miniprojectspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private UUID userId;
    private String email;
    private String password;
    private String profileImage;
}
