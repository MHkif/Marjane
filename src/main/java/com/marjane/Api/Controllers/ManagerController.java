package com.marjane.Api.Controllers;

import com.marjane.DTOs.ManagerDTO;
import com.marjane.DTOs.PromotionCenterDTO;
import com.marjane.DTOs.Requests.LoginRequest;
import com.marjane.DTOs.Requests.RegisterRequest;
import com.marjane.Entities.Manager;
import com.marjane.Entities.ProxyAdmin;
import com.marjane.Entities.SuperAdmin;
import com.marjane.Services.Implementations.ManagerServiceImpl;
import com.marjane.Services.Implementations.PromotionCenterServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class ManagerController {

    private ProxyAdmin proxyAdmin;
    private PromotionCenterServiceImpl promoCenterService;
    private ManagerServiceImpl service;


    @Autowired
    public ManagerController(PromotionCenterServiceImpl promoCenterService, ManagerServiceImpl service) {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setCin("SQ456789");
        superAdmin.setEmail("achkif@gmail.com");
        superAdmin.setFirstName("AbdelMalek");
        superAdmin.setLastName("Achkif");
        superAdmin.setPassword("aqwzsxedc");
        superAdmin.setPhone("+212771311145");

        ProxyAdmin proxyAdmin1 = new ProxyAdmin();
        proxyAdmin1.setSuperAdmin(superAdmin);
        proxyAdmin1.setCin("SQ570980");
        proxyAdmin1.setEmail("achkif@gmail.com");
        proxyAdmin1.setFirstName("AbdelMalek");
        proxyAdmin1.setLastName("Achkif");
        proxyAdmin1.setPassword("aqwzsxedc77");
        proxyAdmin1.setPhone("+212771311145");


        this.proxyAdmin = proxyAdmin1;
        this.promoCenterService = promoCenterService;
        this.service = service;
    }

    @PostMapping(value = "/managers/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ManagerDTO> login(@RequestBody LoginRequest request){
        Optional<Manager> manager = service.login(request.getEmail(), request.getPassword());
        return manager.map(managerEntity -> new ResponseEntity<>(service.mapToDTO(managerEntity), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/managers/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ManagerDTO> register(@RequestBody ManagerDTO request){
        ManagerDTO managerDTO = ManagerDTO.builder()
                .cin(request.getCin())
                .admin(request.getAdmin())
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .build();

        Optional<Manager> manager = service.save(managerDTO);
        return manager.map(managerEntity -> new ResponseEntity<>(service.mapToDTO(managerEntity), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }


    @PostMapping(value = "/managers/promotions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PromotionCenterDTO> getAllPromotionsByManager(@RequestParam String cin){
        return promoCenterService.findAllPromsByManager(cin)
                .stream()
                .map(promoCenterService::mapToDTO)
                .collect(Collectors.toList());
    }
}
