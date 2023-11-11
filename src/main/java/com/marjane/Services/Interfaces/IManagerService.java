package com.marjane.Services.Interfaces;

import com.marjane.DTOs.ManagerDTO;
import com.marjane.Entities.Manager;

import java.util.List;
import java.util.Optional;

public interface IManagerService {
    Optional<Manager> findByCIN(String cin);

    List<ManagerDTO> findAll();

    Optional<Manager>  save(ManagerDTO t);

    void delete(String cin);
}
