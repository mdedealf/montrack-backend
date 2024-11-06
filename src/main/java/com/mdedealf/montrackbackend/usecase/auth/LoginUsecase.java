package com.mdedealf.montrackbackend.usecase.auth;

import com.mdedealf.montrackbackend.infrastructure.users.dto.LoginRequestDTO;
import com.mdedealf.montrackbackend.infrastructure.users.dto.LoginResponseDTO;

public interface LoginUsecase {
    LoginResponseDTO authenticateUser (LoginRequestDTO loginRequestDTO);
}
