package com.marjane.Api.Controllers;


import com.marjane.Entities.ProxyAdmin;
import com.marjane.DTOs.Requests.ProxyAdminRequest;
import com.marjane.DTOs.Responses.ProxyAdminResponse;
import com.marjane.Repositories.SuperAdminRepository;
import com.marjane.Services.Implementations.ProxyAdminServiceImpl;
import com.marjane.Services.Implementations.SuperAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProxyAdminController {

    private ProxyAdminServiceImpl proxyAdminService;
    private SuperAdminRepository superAdminRepository;
    private SuperAdminServiceImpl superAdminService;

    @Autowired
    public ProxyAdminController(ProxyAdminServiceImpl proxyAdminService, SuperAdminServiceImpl superAdminService) {
        this.proxyAdminService = proxyAdminService;
        this.superAdminService = superAdminService;
    }

    @PostMapping(value = "/proxy-admin/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ProxyAdminResponse create(@RequestBody ProxyAdminRequest request, ProxyAdminResponse proxyAdminResponse) {
        proxyAdminResponse.setCin(request.getCin());
        proxyAdminResponse.setFirstName(request.getFirstName());
        proxyAdminResponse.setLastName(request.getLastName());
        proxyAdminResponse.setEmail(request.getEmail());
        proxyAdminResponse.setPassword(request.getPassword());
        proxyAdminResponse.setPhone(request.getPhone());

        ProxyAdmin proxyAdmin = new ProxyAdmin();
        proxyAdmin.setSuperAdmin(superAdminRepository.findById("SQ456789").get());
        proxyAdmin.setCin(request.getCin());
        proxyAdmin.setFirstName(request.getFirstName());
        proxyAdmin.setLastName(request.getLastName());
        proxyAdmin.setEmail(request.getEmail());
        proxyAdmin.setPassword(request.getPassword());
        proxyAdmin.setPhone(request.getPhone());

        proxyAdminService.save((proxyAdmin));

        return proxyAdminResponse;
    }

    

}
