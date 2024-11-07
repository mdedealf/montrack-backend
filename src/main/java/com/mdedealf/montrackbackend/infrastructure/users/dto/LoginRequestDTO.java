package com.mdedealf.montrackbackend.infrastructure.users.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotNull
    @Size(max = 255)
    private String email;

    @NotNull
    private String password;
}