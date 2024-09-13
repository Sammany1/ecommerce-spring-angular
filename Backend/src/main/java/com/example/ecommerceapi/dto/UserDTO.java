package com.example.ecommerceapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {
    private Long id; // optional, can be used for updates
    private String avatar;
    private String firstName;
    private String lastName;
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password; // For registration or password changes
    private LocalDate birthOfDate;
    private String phoneNumber;
    private String role;
    private String accountStatus;
    private Integer failedLoginAttempts;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    public UserDTO(Long id, String avatar, String firstName, String lastName, String username, String email, LocalDate birthOfDate, String phoneNumber, LocalDateTime createdAt, LocalDateTime deletedAt, String role, String accountStatus, Integer failedLoginAttempts, LocalDateTime lastLoginAt) {
        this.id = id;
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.birthOfDate = birthOfDate;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.role = role;
        this.accountStatus = accountStatus;
        this.failedLoginAttempts = failedLoginAttempts;
        this.lastLoginAt = lastLoginAt;
    }

    public Long getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public String getPassword() {
        return password;
    }
}