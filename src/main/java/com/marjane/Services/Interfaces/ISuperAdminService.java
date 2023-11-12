package com.marjane.Services.Interfaces;

import com.marjane.DTOs.Responses.SuperAdminResponse;
import com.marjane.Entities.SuperAdmin;

import java.util.List;
import java.util.Optional;

public interface ISuperAdminService  {
    Optional<SuperAdmin> findByCIN(String cin);

    Optional<SuperAdmin> login(String email, String password);


    SuperAdminResponse mapToDTO(SuperAdmin superAdmin);
}
