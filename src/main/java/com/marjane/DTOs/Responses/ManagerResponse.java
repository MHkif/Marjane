package com.marjane.DTOs.Responses;

import lombok.Data;

@Data
public class ManagerResponse {
    private String cin;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
