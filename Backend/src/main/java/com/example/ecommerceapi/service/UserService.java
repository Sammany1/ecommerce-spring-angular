package com.example.ecommerceapi.service;

import com.example.ecommerceapi.dto.UserDTO;
import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.mapper.UserMapper;
import com.example.ecommerceapi.model.User;
import com.example.ecommerceapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        logger.debug("Entering getAllUsers method");
        List<UserDTO> users = userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
        logger.debug("Exiting getAllUsers method with {} users", users.size());
        return users;
    }

    public UserDTO getUserById(Long id) {
        logger.debug("Entering getUserById method with id: {}", id);
        UserDTO user = userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        logger.debug("Exiting getUserById method with user: {}", user);
        return user;
    }

    public UserDTO getUserByUsername(String username) {
        logger.debug("Entering getUserByUsername method with username: {}", username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
        UserDTO userDTO = UserMapper.toDTO(user);
        logger.debug("Exiting getUserByUsername method with user: {}", userDTO);
        return userDTO;
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        logger.debug("Entering updateUser method with id: {} and userDTO: {}", id, userDTO);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setAvatar(userDTO.getAvatar());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setBirthOfDate(userDTO.getBirthOfDate());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole(userDTO.getRole());
        user.setAccountStatus(userDTO.getAccountStatus());
        user.setFailedLoginAttempts(userDTO.getFailedLoginAttempts());
        user.setLastLoginAt(userDTO.getLastLoginAt());
        UserDTO updatedUser = UserMapper.toDTO(userRepository.save(user));
        logger.debug("Exiting updateUser method with updated user: {}", updatedUser);
        return updatedUser;
    }

    public void deleteUser(Long id) {
        logger.debug("Entering deleteUser method with id: {}", id);
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
        logger.debug("Exiting deleteUser method with id: {}", id);
    }

    public UserDTO updateUserRole(Long id, String role) {
        logger.debug("Entering updateUserRole method with id: {} and role: {}", id, role);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setRole(role);
        UserDTO updatedUser = UserMapper.toDTO(userRepository.save(user));
        logger.debug("Exiting updateUserRole method with updated user: {}", updatedUser);
        return updatedUser;
    }

    public User createUser(User user) {
        logger.debug("Entering createUser method with user: {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userRepository.save(user);
        logger.debug("Exiting createUser method with created user: {}", createdUser);
        return createdUser;
    }

    public User createAdmin(User user) {
        logger.debug("Entering createAdmin method with user: {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ADMIN");
        User createdUser = userRepository.save(user);
        logger.debug("Exiting createAdmin method with created user: {}", createdUser);
        return createdUser;
    }
}