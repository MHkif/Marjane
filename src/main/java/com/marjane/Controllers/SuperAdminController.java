package com.marjane.Controllers;


import com.marjane.DTOs.Responses.SuperAdminResponse;
import com.marjane.DTOs.Requests.LoginRequest;
import com.marjane.Services.Implementations.SuperAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class SuperAdminController  {

    private SuperAdminServiceImpl superAdminService;

    @Autowired
    public SuperAdminController(SuperAdminServiceImpl superAdminService) {
        this.superAdminService = superAdminService;
    }


    @PostMapping(value = "/super-admin/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public SuperAdminResponse login(@RequestBody LoginRequest request, SuperAdminResponse superAdmin) {

        superAdmin.setCin("SQ896089");
        superAdmin.setFirstName("AbdelMalek");
        superAdmin.setLastName("Achkif");
        superAdmin.setEmail(request.getEmail());
        superAdmin.setPassword(request.getPassword());
        return superAdmin;
    }




}
