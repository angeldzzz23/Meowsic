package com.meowsic.meows.repository;


import com.meowsic.meows.entity.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class RoleRepositoryTest  {

    @Autowired
    private RoleRepository roleRepository;

    private Role role;


    @BeforeEach
    void setUp() {
        role = new Role();
        role.setName("ROLE_MANAGER");
        roleRepository.save(role);
    }

    @AfterEach
    void tearDown() {
        roleRepository.delete(role);
        role = null;
    }

    @Test
    void testFindRoleByName_Found(){
        Optional<Role> roleFound = roleRepository.findByName("ROLE_MANAGER");
        assertTrue(roleFound.isPresent());
        assertEquals("ROLE_MANAGER",roleFound.get().getName());

    }

    @Test
    void testFindRoleByName_NotFound(){
        Optional<Role> roleFound = roleRepository.findByName("ROLE_HACKER");
        assertTrue(roleFound.isEmpty());
    }
}
