package com.marjane.Api.Controllers;


import com.marjane.DTOs.ManagerDTO;
import com.marjane.DTOs.Requests.LoginRequest;
import com.marjane.Entities.Manager;
import com.marjane.Entities.ProxyAdmin;
import com.marjane.DTOs.Requests.ProxyAdminRequest;
import com.marjane.DTOs.Responses.ProxyAdminResponse;
import com.marjane.Entities.SuperAdmin;
import com.marjane.Repositories.SuperAdminRepository;
import com.marjane.Services.Implementations.ProxyAdminServiceImpl;
import com.marjane.Services.Implementations.SuperAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
public class ProxyAdminController {

    private ProxyAdminServiceImpl proxyAdminService;
    private SuperAdminServiceImpl superAdminService;

    @Autowired
    public ProxyAdminController(ProxyAdminServiceImpl proxyAdminService, SuperAdminServiceImpl superAdminService) {
        this.proxyAdminService = proxyAdminService;
        this.superAdminService = superAdminService;

    }

    @PostMapping(value = "/proxy-admin/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProxyAdminResponse> login(@RequestBody LoginRequest request){
        Optional<ProxyAdmin> proxyAdmin = proxyAdminService.login(request.getEmail(), request.getPassword());
        return proxyAdmin.map(proxyAdminEnt -> new ResponseEntity<>(proxyAdminService.mapToDTO(proxyAdminEnt), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(value = "/proxy-admin/save", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProxyAdminResponse> save(@RequestBody ProxyAdminRequest request) {
        Optional<SuperAdmin> superAdmin= this.superAdminService.findByCIN("SQ456789");
        if(superAdmin.isPresent()){
            request.setSuperAdmin(superAdmin.get());
            Optional<ProxyAdmin> proxyAdmin = this.proxyAdminService.save(request);
            return proxyAdmin.map(proxyAdminEnt -> new ResponseEntity<>(this.proxyAdminService.mapToDTO(proxyAdminEnt), HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


}
