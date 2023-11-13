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
import com.marjane.Services.Implementations.ProxyAdminServiceImpl;
import com.marjane.Services.Implementations.SuperAdminServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class ManagerController {

    // # TODO : Testing
    private Optional<SuperAdmin> superAdmin;
    private Optional<ProxyAdmin> proxyAdmin;
    private Optional<Manager> manager;
    private PromotionCenterServiceImpl promoCenterService;
    private ManagerServiceImpl service;
    private SuperAdminServiceImpl superAdminService;
    private ProxyAdminServiceImpl proxyAdminService;



    @Autowired
    public ManagerController(PromotionCenterServiceImpl promoCenterService,
                             ManagerServiceImpl service, SuperAdminServiceImpl superAdminService,
                             ProxyAdminServiceImpl proxyAdminService) {
        this.promoCenterService = promoCenterService;
        this.service = service;
        this.superAdminService = superAdminService;
        this.proxyAdminService = proxyAdminService;

        this.superAdmin= this.superAdminService.findByCIN("SQ456789");
        this.proxyAdmin = this.proxyAdminService.findByCIN("SQ570980");
        this.manager = this.service.findByCIN("DQ456865");
    }

    @PostMapping(value = "/managers/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ManagerDTO> login(@RequestBody LoginRequest request){
        Optional<Manager> manager = service.login(request.getEmail(), request.getPassword());
        return manager.map(managerEntity -> new ResponseEntity<>(service.mapToDTO(managerEntity), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/managers/save", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ManagerDTO> save(@RequestBody ManagerDTO managerDTO){
        if(this.proxyAdmin.isEmpty()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Optional<Manager> manager = service.save(managerDTO);
        return manager.map(managerEntity -> new ResponseEntity<>(service.mapToDTO(managerEntity), HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }



    @GetMapping(value = "/managers/promotions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<PromotionCenterDTO>> getAllPromotionsByManager() {

        if (this.manager.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
/*
        if(!this.service.isCurrentTimeInRange()){
            try {
                throw  new Exception("En tant que manager, vous ne pouvez voir les promotions que de 8 à 12 heures .");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
 */
        List<PromotionCenterDTO> promotions = promoCenterService.findAllPromsByManager(this.manager.get())
                .stream()
                .map(promoCenterService::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(promotions);
    }

}
