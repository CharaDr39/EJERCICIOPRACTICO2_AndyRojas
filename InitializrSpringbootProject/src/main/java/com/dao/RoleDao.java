package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Role;
public interface RoleDao extends JpaRepository<Role,Long> {}
