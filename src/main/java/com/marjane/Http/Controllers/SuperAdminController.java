package com.marjane.Controllers;

import com.marjane.Entities.Manager;
import com.marjane.Entities.SuperAdmin;
import com.marjane.Requests.ProxyAdminRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuperAdminController {
    @GetMapping(value = "/super-admin/login")
    public String loginView() {
        return "[ Api ] : SuperAdmin Login\t\t[ You need to provide Email & Password and submit ]";
    }
    @PostMapping(value = "/super-admin/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public SuperAdmin login(@RequestBody String data) {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setCin("SQ896089");
        return superAdmin;
    }

    @GetMapping(value = "super-admin/create/proxyAdmin")
    public String createProxyAdminView() {
        return "[ Api : SuperAdmin] :  Create\t\t[ You need to provide Proxy Admin data and submit ]";
    }

    @PostMapping(value = "super-admin/create/proxyAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createProxyAdmin(@RequestBody ProxyAdminRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        return "Data from createProxyAdmin: Email: " + email + " | Password: " + password
                + " | First Name: " + firstName + " | Last Name: " + lastName;
    }

    @GetMapping(value = "super-admin/create/manager")
    public String createManagerView() {
        return "[ Api : SuperAdmin] :  Create\t\t[ You need to provide Proxy Manager data and submit ]";
    }

    @PostMapping(value = "super-admin/create/manager")
    public String createManager(@RequestBody String data) {
        Manager manager = new Manager();
        return "Data from createManager : "+ data;
        //return manager;
    }


    @GetMapping(value = "super-admin/create/center")
    public String createCenterView() {
        return "[ Api : SuperAdmin] :  Create\t\t[ You need to provide Proxy Center data and submit ]";
    }

    @PostMapping(value = "super-admin/create/center")
    public String createCenter(@RequestBody String data) {
        Manager manager = new Manager();
        return "Data from createCenter : "+ data;
        //return manager;
    }


}
