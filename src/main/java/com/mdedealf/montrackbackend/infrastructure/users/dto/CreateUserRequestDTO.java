package com.mdedealf.montrackbackend.infrastructure.users.dto;

import com.mdedealf.montrackbackend.entity.Role;
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
    private String email;
    private String password;
    private String pin;
    private String profilePictureUrl;

    public Users toEntity() {
        Users user = new Users();
        user.setEmail(email);
        user.setPasswordHash(password);
        user.setPin(pin);
        user.setProfilePicture(profilePictureUrl);
        user.setOnboardingCompleted(false);
        Set<Role> roles = new HashSet<>();
        user.setRoles(roles);
        return user;
    }
}
