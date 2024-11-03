package com.mdedealf.montrackbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Long userId;
    private String fullName;
    private String email;
    private String passwordHash;
    private String profilePicture;
    private String pinHash;
    private boolean isOnboardingCompleted;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;
}
