package com.marjane.Api.Controllers;


import com.marjane.DTOs.Responses.SuperAdminResponse;
import com.marjane.DTOs.Requests.LoginRequest;
import com.marjane.Entities.Manager;
import com.marjane.Entities.SuperAdmin;
import com.marjane.Services.Implementations.SuperAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class SuperAdminController  {

    private SuperAdminServiceImpl service;

    @Autowired
    public SuperAdminController(SuperAdminServiceImpl superAdminService) {
        this.service = superAdminService;
    }


    @PostMapping(value = "/super-admin/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SuperAdminResponse> login(@RequestBody LoginRequest request){
        Optional<SuperAdmin> superAdmin = service.login(request.getEmail(), request.getPassword());
        return superAdmin.map(superAdminEntity -> new ResponseEntity<>(service.mapToDTO(superAdminEntity), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
