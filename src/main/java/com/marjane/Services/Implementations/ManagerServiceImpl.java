package com.marjane.Services.Implementations;

import com.marjane.DTOs.ManagerDTO;
import com.marjane.Entities.Manager;
import com.marjane.Repositories.ManagerRepository;
import com.marjane.Services.Interfaces.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements IManagerService {

    private ManagerRepository repository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Manager> findByCIN(String cin) {
        return repository.findById(cin);
    }

    @Override
    public List<ManagerDTO> findAll() {
        return null;
    }

    @Override
    public Manager save(ManagerDTO managerDTO) {
        return repository.save(mapToEntity(managerDTO));
    }

    @Override
    public void delete(String cin) {

    }

    @Override
    public Optional<Manager> login(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public ManagerDTO mapToDTO(Manager manager){
        return ManagerDTO.builder()
                .cin(manager.getCin())
                .admin(manager.getAdmin())
                .email(manager.getEmail())
                .password(manager.getPassword())
                .firstName(manager.getFirstName())
                .lastName(manager.getLastName())
                .phone(manager.getPhone())
                .build();
    }

    public Manager mapToEntity(ManagerDTO managerDTO){
        Manager manager =  new Manager();
        manager.setCin(manager.getCin());
        manager.setAdmin(managerDTO.getAdmin());
        manager.setEmail(managerDTO.getEmail());
        manager.setPassword(managerDTO.getPassword());
        manager.setFirstName(managerDTO.getFirstName());
        manager.setLastName(managerDTO.getLastName());
        manager.setPhone(managerDTO.getPhone());

        return manager;
    }
}