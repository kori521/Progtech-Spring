package com.kornel.progtech.repository;

import com.kornel.progtech.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}