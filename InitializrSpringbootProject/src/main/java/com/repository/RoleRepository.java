package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {}
