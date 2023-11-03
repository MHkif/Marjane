package com.marjane.Http.Requests;

import lombok.Data;

@Data
public class ProxyAdminRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
