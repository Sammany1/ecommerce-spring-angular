package com.example.ecommerceapi.mapper;

import com.example.ecommerceapi.dto.UserDTO;
import com.example.ecommerceapi.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getAvatar(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getBirthOfDate(),
                user.getPhoneNumber(),
                user.getCreatedAt(),
                user.getDeletedAt(),
                user.getRole(),
                user.getAccountStatus(),
                user.getFailedLoginAttempts(),
                user.getLastLoginAt()
        );
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setAvatar(userDTO.getAvatar());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setBirthOfDate(userDTO.getBirthOfDate());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setDeletedAt(userDTO.getDeletedAt());
        user.setRole(userDTO.getRole());
        user.setAccountStatus(userDTO.getAccountStatus());
        user.setFailedLoginAttempts(userDTO.getFailedLoginAttempts());
        user.setLastLoginAt(userDTO.getLastLoginAt());
        return user;
    }
}