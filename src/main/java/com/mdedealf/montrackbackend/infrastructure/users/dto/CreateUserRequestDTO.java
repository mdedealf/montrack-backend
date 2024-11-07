package com.mdedealf.montrackbackend.infrastructure.users.dto;

import com.mdedealf.montrackbackend.entity.Roles;
import com.mdedealf.montrackbackend.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDTO {
    private String fullName;
    private String email;
    private String passwordHash;
    private String profilePicture;
    private String pin;

    public Users toEntity() {
        Users user = new Users();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        user.setPin(pin);
        user.setProfilePicture(profilePicture);
        user.setOnboardingCompleted(false);
        Set<Roles> roles = new HashSet<>();
        user.setRoles(roles);
        return user;
    }
}
