package com.marjane.Services.Interfaces;

import com.marjane.DTOs.ManagerDTO;
import com.marjane.DTOs.Requests.ProxyAdminRequest;
import com.marjane.DTOs.Responses.ProxyAdminResponse;
import com.marjane.Entities.Manager;
import com.marjane.Entities.ProxyAdmin;

import java.util.List;
import java.util.Optional;

public interface IProxyAdminService {
    Optional<ProxyAdmin> findByCIN(String cin);

    List<ProxyAdminResponse> findAll();

    void delete(String cin);

    Optional<ProxyAdmin> save(ProxyAdminRequest proxyAdminRequest);

    Optional<ProxyAdmin> login(String email, String password);
}
