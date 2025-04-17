package com.service;

import com.domain.Role;
import java.util.List;

public interface RoleService {
    List<Role> listarTodas();
    Role buscarPorId(Long id);
}
