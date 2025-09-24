package com.healthcare.staff_management.dto;

import lombok.Data;

@Data

public class NewUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
