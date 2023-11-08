package com.marjane.Services.Interfaces;

import java.util.List;

public interface ISuperAdminService<T>  {
    T findByCIN(String cin);

    T findByEmailAndPassword(String email, String password);

    List<T> findAll();

}
