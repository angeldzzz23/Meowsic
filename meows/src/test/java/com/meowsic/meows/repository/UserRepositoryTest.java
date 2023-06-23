package com.meowsic.meows.repository;


import com.meowsic.meows.entity.Role;
import com.meowsic.meows.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    private User user;

    @BeforeEach
    void setUp() {
        Role role = new Role();
        role.setName("ROLE_USER");
        roleRepository.save(role);
        Set<Role> set = new HashSet<>();
        Role roleFound = roleRepository.findByName("ROLE_USER").get();
        set.add(roleFound);
        user = new User();
        user.setEmail("c@gmail.com");
        user.setUsername("Grimes");
        user.setPassword("test");
        user.setRoles(set);
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void TestFindByEmail_Found(){
        Optional<User> user = userRepository.findByEmail("c@gmail.com");
        Set<Role> set = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_USER").get();
        set.add(role);
        assertTrue(user.isPresent());
        assertEquals("c@gmail.com",user.get().getEmail());
        assertEquals("Grimes",user.get().getUsername());
        assertEquals("test",user.get().getPassword());
        assertEquals(set,user.get().getRoles());

    }

    @Test
    void TestFindByEmail_NotFound(){
        Optional<User> user = userRepository.findByEmail("grimes@gmail.com");
        assertTrue(user.isEmpty());

    }

    @Test
    void TestFindByUsername_Found(){
        Optional<User> user = userRepository.findByUsername("Grimes");
        Set<Role> set = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_USER").get();
        set.add(role);
        assertTrue(user.isPresent());
        assertEquals("c@gmail.com",user.get().getEmail());
        assertEquals("Grimes",user.get().getUsername());
        assertEquals("test",user.get().getPassword());
        assertEquals(set,user.get().getRoles());
    }

    @Test
    void TestFindByUsername_NotFound(){
        Optional<User> user = userRepository.findByUsername("C");
        assertTrue(user.isEmpty());

    }

    @Test
    void TestFindByEmailorUsername_Found(){
        //wrong email
        Optional<User> userWithUsername = userRepository.findByUsernameOrEmail("Grimes","grimes@gmail.com");
        //wrong username
        Optional<User> userWithEmail = userRepository.findByUsernameOrEmail("C","c@gmail.com");
        Set<Role> set = new HashSet<>();
        Role role = roleRepository.findByName("ROLE_USER").get();
        set.add(role);
        assertTrue(userWithUsername.isPresent());
        assertTrue(userWithEmail.isPresent());
        assertEquals("c@gmail.com",userWithEmail.get().getEmail());
        assertEquals("Grimes",userWithEmail.get().getUsername());
        assertEquals("test",userWithEmail.get().getPassword());
        assertEquals(set,userWithEmail.get().getRoles());
        assertEquals("c@gmail.com",userWithUsername.get().getEmail());
        assertEquals("Grimes",userWithUsername.get().getUsername());
        assertEquals("test",userWithUsername.get().getPassword());
        assertEquals(set,userWithUsername.get().getRoles());

    }

    @Test
    void TestFindByEmailorUsername_NotFound(){
        Optional<User> user = userRepository.findByUsernameOrEmail("Visions","go@gmail.com");
        assertTrue(user.isEmpty());
    }

    @Test
    void TestExistsByEmail_Exists(){
        Boolean exists = userRepository.existsByEmail("c@gmail.com");
        assertTrue(exists);
    }

    @Test
    void TestExistsByEmail_NotExistent(){
        Boolean exists = userRepository.existsByEmail("grimes@gmail.com");
        assertFalse(exists);
    }

    @Test
    void TestExistsByUsername_Exists(){
        Boolean exists = userRepository.existsByUsername("Grimes");
        assertTrue(exists);
    }

    @Test
    void TestExistsByUsername_NotExistent(){
        Boolean exists = userRepository.existsByUsername("C");
        assertFalse(exists);
    }
}
