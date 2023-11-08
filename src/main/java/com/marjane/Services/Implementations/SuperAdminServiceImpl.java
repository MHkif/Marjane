package com.marjane.Services.Implementations;

import com.marjane.DTOs.Responses.SuperAdminResponse;
import com.marjane.Repositories.SuperAdminRepository;
import com.marjane.Services.Interfaces.ISuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements ISuperAdminService<Optional<SuperAdminResponse>> {

    private  SuperAdminRepository repository;

    @Autowired
    public SuperAdminServiceImpl(SuperAdminRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<SuperAdminResponse> findByCIN(String cin) {
         repository.findById(cin).orElse(null);
         return null;
    }

    @Override
    public Optional<SuperAdminResponse> findByEmailAndPassword(String email, String password) {
        return Optional.empty();
    }

    @Override
    public List<Optional<SuperAdminResponse>> findAll() {
         repository.findAll();
         return null;
    }



}
