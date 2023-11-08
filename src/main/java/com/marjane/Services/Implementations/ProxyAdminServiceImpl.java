package com.marjane.Services.Implementations;

import com.marjane.DTOs.Responses.ProxyAdminResponse;
import com.marjane.Entities.ProxyAdmin;
import com.marjane.Repositories.ProxyAdminRepository;
import com.marjane.Services.Interfaces.IProxyAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProxyAdminServiceImpl implements IProxyAdminService<ProxyAdminResponse, ProxyAdmin> {

    private ProxyAdminRepository repository;


    @Autowired
    public ProxyAdminServiceImpl(ProxyAdminRepository repository) {
        this.repository = repository;
    }


    @Override
    public ProxyAdminResponse findByCIN(String cin) {

         repository.findById(cin).orElse(null);
         return null;
    }

    @Override
    public List<ProxyAdminResponse> findAll() {

         repository.findAll();
         return null;
    }

    @Override
    public ProxyAdminResponse save(ProxyAdmin proxyAdmin) {

         repository.save(proxyAdmin);
         return null;
    }

    @Override
    public void delete(String cin) {
        repository.deleteById(cin);
    }


}
