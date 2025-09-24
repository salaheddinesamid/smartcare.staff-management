package com.healthcare.staff_management.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
