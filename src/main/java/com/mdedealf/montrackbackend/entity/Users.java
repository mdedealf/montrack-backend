package com.mdedealf.montrackbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "montrack")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_user_id_seq", allocationSize = 1)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Size(max = 150)
    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @NotNull
    @Size(max = 255)
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Size(max = 255)
    @Column(name = "profile_picture", length = 255)
    private String profilePicture;

    @NotNull
    @Size(min = 4, max = 4)
    @Column(name = "pin", nullable = false, length = 4)
    private String pin;

    @Column(name = "is_onboarding_completed", nullable = false)
    private boolean isOnboardingCompleted;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @Column(name = "created_at")
    private ZonedDateTime deletedAt;
}
