// src/main/java/com/serviceimplementation/RoleServiceImpl.java
package com.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.Role;
import com.repository.RoleRepository;
import com.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repo;
    @Override
    public List<Role> listarTodos() {
        return repo.findAll();
    }
}
