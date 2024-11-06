package com.mdedealf.montrackbackend.usecase.auth.impl;

import com.mdedealf.montrackbackend.common.exceptions.DataNotFoundException;
import com.mdedealf.montrackbackend.infrastructure.security.TokenService;
import com.mdedealf.montrackbackend.infrastructure.users.dto.LoginRequestDTO;
import com.mdedealf.montrackbackend.infrastructure.users.dto.LoginResponseDTO;
import com.mdedealf.montrackbackend.usecase.auth.LoginUsecase;
import lombok.extern.java.Log;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;


@Log
@Service
public class LoginUsecaseImpl implements LoginUsecase {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public LoginUsecaseImpl (AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public LoginResponseDTO authenticateUser (LoginRequestDTO req) {
        try {
            log.info("Logginin with");
            log.info(req.getEmail());
            log.info(req.getPassword());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
            );
            // Generating token
            String token = tokenService.generateToken(authentication);
            return new LoginResponseDTO(token);
        } catch (AuthenticationException e) {
            throw new DataNotFoundException("Wrong credentials");
        }
    }
}
