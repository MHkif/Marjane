package com.marjane.Repositories;

import com.marjane.Entities.SuperAdmin;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, String> {
    Optional<SuperAdmin> findByEmail(String email);
}
