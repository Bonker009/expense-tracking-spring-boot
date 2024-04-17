package org.example.miniprojectspring.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO{
    private Integer userId;
    private String email;
    private String password;
    private String profileImage;
}
