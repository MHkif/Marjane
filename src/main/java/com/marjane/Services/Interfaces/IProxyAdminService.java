package com.marjane.Services.Interfaces;

import java.util.List;

public interface IProxyAdminService<DTO, T> {
    DTO findByCIN(String cin);

    List<DTO> findAll();

    DTO save(T t);

    void delete(String cin);
}
