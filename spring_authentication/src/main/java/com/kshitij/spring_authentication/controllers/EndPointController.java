package com.kshitij.spring_authentication.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kshitij.spring_authentication.models.Role;
import com.kshitij.spring_authentication.models.User;
import com.kshitij.spring_authentication.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class EndPointController {

    @Autowired
    private UserRepository userRepository;

    // Fetch all users (Admin functionality)
    @GetMapping("/admin/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<Object> userInfo = users.stream().map(user -> {
            return new HashMap<String, Object>() {
                {
                    put("id", user.getId());
                    put("username", user.getUsername());
                    put("email", user.getEmail());
                    put("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
                }
            };
        }).collect(Collectors.toList());
        return ResponseEntity.ok(userInfo);
    }

}
