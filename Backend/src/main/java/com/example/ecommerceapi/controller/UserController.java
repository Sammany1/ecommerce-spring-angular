package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.dto.UserDTO;
import com.example.ecommerceapi.service.CustomSecurityService;
import com.example.ecommerceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomSecurityService customSecurityService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/me")
    public UserDTO getCurrentUser(Principal principal) {
        return userService.getUserByUsername(principal.getName());
    }

    @PreAuthorize("hasRole('ADMIN') or @customSecurityService.isUserOwnProfile(#id)")
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN') or @customSecurityService.isUserOwnProfile(#id)")
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/role")
    public UserDTO updateUserRole(@PathVariable Long id, @RequestParam String role) {
        return userService.updateUserRole(id, role);
    }
}