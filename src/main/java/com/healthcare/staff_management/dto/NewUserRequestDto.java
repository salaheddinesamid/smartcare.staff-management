package com.healthcare.staff_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roleName;
}
