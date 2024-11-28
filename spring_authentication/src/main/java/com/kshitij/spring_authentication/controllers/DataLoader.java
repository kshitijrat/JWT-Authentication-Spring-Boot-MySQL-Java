package com.kshitij.spring_authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kshitij.spring_authentication.models.ERole;
import com.kshitij.spring_authentication.models.Role;
import com.kshitij.spring_authentication.repository.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if roles exist, if not, insert them
        if (!roleRepository.existsByName(ERole.ROLE_USER)) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (!roleRepository.existsByName(ERole.ROLE_ADMIN)) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
        if (!roleRepository.existsByName(ERole.ROLE_MODERATOR)) {
            roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        }
    }
}


