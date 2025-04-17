package com.serviceimplementation;

import com.domain.Role;
import com.repository.RoleRepository;
import com.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> listarTodas() {
        return repository.findAll();
    }

    @Override
    public Role buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
