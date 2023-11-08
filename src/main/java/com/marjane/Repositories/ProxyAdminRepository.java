package com.marjane.Repositories;

import com.marjane.Entities.ProxyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProxyAdminRepository extends JpaRepository<ProxyAdmin, String> {
}
