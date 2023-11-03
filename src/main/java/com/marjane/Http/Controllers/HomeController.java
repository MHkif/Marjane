package com.marjane.Controllers;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    @GetMapping(value = {"/", ""})
    public String sayHello() {
        return "Hello, World!";
    }
}
