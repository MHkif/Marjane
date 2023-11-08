package com.marjane.DTOs.Requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String cin;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}