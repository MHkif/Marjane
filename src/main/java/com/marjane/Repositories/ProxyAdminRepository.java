package com.marjane.Repositories;

import com.marjane.Entities.Manager;
import com.marjane.Entities.ProxyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProxyAdminRepository extends JpaRepository<ProxyAdmin, String> {
    Optional<ProxyAdmin> findByEmailAndPassword(String email, String password);
}
