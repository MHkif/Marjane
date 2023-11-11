package com.marjane.Api.Controllers;

import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.DTOs.PromotionCenterDTO;
import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Entities.ProductPromotion;
import com.marjane.Entities.PromotionCenter;
import com.marjane.Enums.PromotionStatus;
import com.marjane.Services.Implementations.ProductPromotionServiceImpl;

import com.marjane.Services.Implementations.PromotionCenterServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@NoArgsConstructor

public class PromotionController {

    private ProductPromotionServiceImpl prodPromoService;
    private PromotionCenterServiceImpl promoCenterService;


    @Autowired
    public PromotionController(
            ProductPromotionServiceImpl service,
            PromotionCenterServiceImpl promotionCenterService) {

        this.prodPromoService = service;
        this.promoCenterService = promotionCenterService;
    }




    @PostMapping(value = "/promotions/products/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductPromotionDTO> savePromotion(@RequestBody ProductPromotionDTO promotionDTO) {
        Optional<ProductPromotion> promotion = prodPromoService.save(promotionDTO);
        return promotion.map(
                productPromotion -> new ResponseEntity<>(
                        prodPromoService.mapToDTO(productPromotion), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping(value = "/promotions/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductPromotionDTO> updatePromotion(@PathVariable("id") Long id) {
        // #TODO : Need to fix
        ProductPromotion promotion = null;
        try {
            promotion = prodPromoService.findById(id).orElseThrow(() -> new Exception("Center not found with ID "+ id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //  Optional<ProductPromotion> promotion = prodPromoService.update(promotionDTO);
        return prodPromoService.update(prodPromoService.mapToDTO(promotion)).map(
                        productPromotion -> new ResponseEntity<>(
                                prodPromoService.mapToDTO(productPromotion), HttpStatus.OK)
                )
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @RequestMapping(value = "/promotions/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductPromotionDTO> getPromotion(@PathVariable("id") Long id){
        Optional<ProductPromotion> promotion = prodPromoService.findById(id);
        return promotion.map(productPromotion -> new ResponseEntity<>(prodPromoService.mapToDTO(productPromotion), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/promotions/products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    // It indicates that the method does not return a view name but the actual data that should be sent in the response.
    // @ResponseBody This annotation is used to indicate that the return value of the method should be serialized directly to the body of the HTTP response.
    public List<ProductPromotionDTO> getAllPromotions(){
        return prodPromoService.findAll()
                .stream()
                .map(prodPromoService::mapToDTO)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/promotions/{centerId}/{promoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PromotionCenterDTO> getPromotionCenter(@PathVariable("centerId") Long centerId, @PathVariable("promoId") Long promoId){
        Optional<PromotionCenter> promotionCenter = promoCenterService.findById(new PromotionCenterId(centerId, promoId));
        return promotionCenter.map(promoCenter -> new ResponseEntity<>(promoCenterService.mapToDTO(promoCenter), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @RequestMapping(value = "/promotions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PromotionCenterDTO> getAllPromotionsWithCenters(){
        return promoCenterService.findAll()
                .stream()
                .map(promoCenterService::mapToDTO)
                .collect(Collectors.toList());
    }


    @PostMapping(value = "/promotions/apply", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    // It indicates that the method does not return a view name but the actual data that should be sent in the response.
    // @ResponseBody This annotation is used to indicate that the return value of the method should be serialized directly to the body of the HTTP response.
    public List<PromotionCenterDTO> ApplyToPromotions(@RequestBody List<PromotionCenterDTO>  promotions){
        // # TODO : Filter promotions , update only the applied promotions

        List<PromotionCenterDTO> allPromotions =  promoCenterService.findAll()
                .stream()
                .map(promoCenterService::mapToDTO)
                .collect(Collectors.toList());

        List<PromotionCenterDTO> promotionsToUpdate = promotions.stream()
                .filter(promotionCenterDTO ->
                        allPromotions.stream()
                                .noneMatch(allPromotion ->
                                        allPromotion.getId().equals(promotionCenterDTO.getId()) &&
                                                allPromotion.getStatus() == promotionCenterDTO.getStatus()
                                )
                )
                .collect(Collectors.toList());
        //return promotionsToUpdate;

        return promotionsToUpdate.stream()
                .peek(promotionCenterDTO -> {
                    promotionCenterDTO.setPerformedAt(LocalDateTime.now());
                    promoCenterService.save(promotionCenterDTO);
                })
                .collect(Collectors.toList());



    }


}
