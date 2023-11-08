package com.marjane.Controllers;

import com.marjane.DTOs.Requests.PromotionRequest;
import com.marjane.DTOs.Responses.ProductPromotionResponse;
import com.marjane.DTOs.Responses.PromotionResponse;
import com.marjane.Entities.*;
import com.marjane.Entities.Abstracts.Promotion;
import com.marjane.Services.Implementations.ProductPromotionServiceImpl;
import com.marjane.Services.Implementations.PromotionServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@NoArgsConstructor

public class PromotionController {

    private PromotionServiceImpl<PromotionResponse<ProductPromotion>> productPromotionService;
    private PromotionServiceImpl<PromotionResponse<CategoryPromotion>> categoryPromotionService;
    private PromotionServiceImpl<PromotionResponse<SubCategoryPromotion>> subCategoryPromotionService;
    private ProductPromotionServiceImpl service;

    @Autowired
    public PromotionController(PromotionServiceImpl<PromotionResponse<ProductPromotion>> productPromotionService,
                               PromotionServiceImpl<PromotionResponse<CategoryPromotion>> categoryPromotionService,
                               PromotionServiceImpl<PromotionResponse<SubCategoryPromotion>> subCategoryPromotionService,
                               ProductPromotionServiceImpl service) {
        this.productPromotionService = productPromotionService;
        this.categoryPromotionService = categoryPromotionService;
        this.subCategoryPromotionService = subCategoryPromotionService;
        this.service = service;
    }


    @PostMapping(value = "/create-promotion", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PromotionResponse<Promotion> createPromotion(@RequestBody PromotionRequest<ProductPromotion> request,  PromotionResponse<Promotion> promotion) {

        // # TODO: call Service;
        switch (request.getType()){
            case "product" : {
                break;}
            case "category" : {break;}
            case "subCategory" : {break;}

        }

        promotion.setPromotion(request.getPromotion());

        return promotion;
    }

    @PostMapping(value = "/create-promotion/product", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PromotionResponse<ProductPromotion> productPromotion(@RequestBody PromotionRequest<ProductPromotion> request, PromotionResponse<ProductPromotion> promotion) {
        Optional<ProductPromotionResponse> productPromotion = service.save(request.getPromotion());
        promotion.setPromotion(productPromotion.get().getPromotion());


        return promotion;
    }
    @PostMapping(value = "/create-promotion/category", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PromotionResponse<CategoryPromotion> categoryPromotion(@RequestBody PromotionRequest<CategoryPromotion> request, PromotionResponse<CategoryPromotion> promotion) {
        PromotionResponse<CategoryPromotion> categoryPromotion = categoryPromotionService.save(request.getPromotion());

        List<SubCategory> subCategories = categoryPromotion.getPromotion().getCategory().getSubCategories();
        List<Product> productList = subCategories.stream()
                .flatMap(sub -> sub.getProducts().stream())
                .collect(Collectors.toList());
       if(!productList.isEmpty()){
           for (Product product : productList) {
               ProductPromotion  productPromotion = new ProductPromotion();
               productPromotion.setAdmin(categoryPromotion.getPromotion().getAdmin());
               productPromotion.setProduct(product);
               productPromotion.setPercentage(categoryPromotion.getPromotion().getPercentage());
               productPromotion.setPromotionCenters(null);
               productPromotion.setCreatedAt(categoryPromotion.getPromotion().getCreatedAt());
               productPromotion.setStartAt(categoryPromotion.getPromotion().getStartAt());
               productPromotion.setEndAt(categoryPromotion.getPromotion().getEndAt());
               service.save(productPromotion);

           }
           //ProductPromotionResponse response = new ProductPromotionResponse(3L, productPromotion);
       }else {
           System.out.println("Error = ");
           try {
               throw  new Exception();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }


        promotion.setPromotion(categoryPromotion.getPromotion());
        return promotion;
    }

    @PostMapping(value = "/create-promotion/subCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PromotionResponse<SubCategoryPromotion> subCategoryPromotion(@RequestBody PromotionRequest<SubCategoryPromotion> request, PromotionResponse<SubCategoryPromotion> promotion) {
        PromotionResponse<SubCategoryPromotion> subCategoryPromotion = subCategoryPromotionService.save(request.getPromotion());
        promotion.setPromotion(subCategoryPromotion.getPromotion());

        return promotion;
    }


}
