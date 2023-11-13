package com.marjane.Services.Implementations;

import com.marjane.DTOs.ManagerDTO;
import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.DTOs.PromotionCenterDTO;
import com.marjane.Entities.Center;
import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Entities.Manager;
import com.marjane.Entities.ProductPromotion;
import com.marjane.Repositories.CenterRepository;
import com.marjane.Repositories.ProductPromotionRepository;
import com.marjane.Services.Interfaces.IProductPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductPromotionServiceImpl implements IProductPromotionService {

    private ProductPromotionRepository repository;
    private StockServiceImpl stockService;
    private PromotionCenterServiceImpl promotionCenterService;
    private ManagerServiceImpl managerService;


    @Autowired
    public ProductPromotionServiceImpl(ProductPromotionRepository repository,
                                       PromotionCenterServiceImpl promotionCenterService,
                                       ManagerServiceImpl managerService,
                                       StockServiceImpl stockService) {
        this.repository = repository;
        this.promotionCenterService = promotionCenterService;
        this.managerService = managerService;
        this.stockService = stockService;
    }




    @Override
    public Optional<ProductPromotion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductPromotion> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductPromotion> save(ProductPromotionDTO promotion) {
        int Qnt = stockService.findByProduct(promotion.getProduct()).getQuantity();
        if(Qnt <= 0){
            try {
                throw  new Exception("Stock Quantity : 0 , This product is not available , Check the Stock");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // Testing on Computers Category
        else if(promotion.getProduct().getCategory().getName().equals("Computers & Accessories") && promotion.getPercentage().intValue() > 20){
            try {
                throw  new Exception("Promotion of Computers & Accessories products must not exceed 20%.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(promotion.getPercentage().intValue() > 50){
            try {
                throw  new Exception("Each promotion must not exceed 50% of the product price");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {

            ProductPromotion productPromotion = mapToEntity(promotion);
            Optional<Manager> manager = managerService.findByCIN(productPromotion.getProduct().getCategory().getDepartment().getManager().getCin());

            if (manager.isPresent()) {
                repository.save(productPromotion);

                List<PromotionCenterDTO> promotionCenterDTOs = promotion.getCenters().stream()
                        .map(center -> {
                            try {
                                return PromotionCenterDTO.builder()
                                        .id(new PromotionCenterId(productPromotion.getId(), center.getId()))
                                        .productPromotion(productPromotion)
                                        //.center(centerRepository.findById(2L).orElseThrow(() -> new Exception("Center not found with ID 2")))
                                        .center(Optional.of(center).orElseThrow(() -> new Exception("Center not found with ID " + center.getId())))
                                        .manager(manager.orElseThrow(() -> new Exception("Manager not found")))
                                        .performedAt(null)
                                        .build();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .collect(Collectors.toList());

                promotionCenterDTOs.forEach(promotionCenterService::save);

                return Optional.of(productPromotion);
            } else {
                return Optional.empty();
            }
        }

    }

    @Override
    public Optional<ProductPromotion> update(ProductPromotionDTO promotion) {
        ProductPromotion productPromotion = mapToEntity(promotion);
        // Directly fetch the Manager entity
        Optional<Manager> manager = managerService.findByCIN(productPromotion.getProduct().getCategory().getDepartment().getManager().getCin());

        if(manager.isPresent()){
            repository.save(productPromotion);

            // Use Stream API for PromotionCenterDTO creation
            List<PromotionCenterDTO> promotionCenterDTOs = promotion.getCenters().stream()
                    .map(center -> {
                        try {
                            return PromotionCenterDTO.builder()
                                    .id(new PromotionCenterId(productPromotion.getId(), 2L))
                                    .productPromotion(productPromotion)
                                    .center(Optional.of(center).orElseThrow(() -> new Exception("Center not found with ID " + center.getId())))
                                    .manager(manager.orElseThrow(() -> new Exception("Manager not found")))
                                    .performedAt(null)
                                    .build();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());

            // Save all PromotionCenterDTOs
            promotionCenterDTOs.forEach(promotionCenterService::save);

            return Optional.of(productPromotion);
        }else {
            return Optional.empty();
        }

    }


    @Override
    public void delete(Long id) {

    }

    public ProductPromotionDTO mapToDTO(ProductPromotion promotion){
        if (promotion == null) {
            return null; // or throw an exception, depending on your requirements
        }
        return ProductPromotionDTO.builder()
                .id(promotion.getId())
                .admin(promotion.getAdmin())
                .product(promotion.getProduct())
                .percentage(promotion.getPercentage())
                .createdAt(promotion.getCreatedAt())
                .startAt(promotion.getStartAt())
                .endAt(promotion.getEndAt())
                .build();
    }

    public ProductPromotion mapToEntity(ProductPromotionDTO promotion){
        if (promotion == null) {
            return null; // or throw an exception, depending on your requirements
        }
        ProductPromotion productPromotion =  new ProductPromotion();
        productPromotion.setId(promotion.getId());
        productPromotion.setAdmin(promotion.getAdmin());
        productPromotion.setProduct(promotion.getProduct());
        productPromotion.setPercentage(promotion.getPercentage());
        productPromotion.setCreatedAt(promotion.getCreatedAt());
        productPromotion.setStartAt(promotion.getStartAt());
        productPromotion.setEndAt(promotion.getEndAt());

        return productPromotion;
    }
}
