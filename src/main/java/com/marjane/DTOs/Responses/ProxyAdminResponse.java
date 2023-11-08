package com.marjane.DTOs.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProxyAdminResponse {
    private String cin;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
