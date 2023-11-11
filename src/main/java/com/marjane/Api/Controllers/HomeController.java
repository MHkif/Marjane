package com.marjane.Api.Controllers;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    @GetMapping(value = {"/", ""})
    public String sayHello() {
        return "Hola, Mundo!";
    }
}
