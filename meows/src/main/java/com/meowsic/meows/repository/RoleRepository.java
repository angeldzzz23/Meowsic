package com.meowsic.meows.repository;

import com.meowsic.meows.entity.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String name);
}
