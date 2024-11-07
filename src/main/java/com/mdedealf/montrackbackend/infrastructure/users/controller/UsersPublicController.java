package com.mdedealf.montrackbackend.infrastructure.users.controller;

import com.mdedealf.montrackbackend.common.response.ApiResponse;
import com.mdedealf.montrackbackend.infrastructure.security.Claims;
import com.mdedealf.montrackbackend.infrastructure.users.dto.CreateUserRequestDTO;
import com.mdedealf.montrackbackend.usecase.user.CreateUserUsecase;
import com.mdedealf.montrackbackend.usecase.user.GetUsersUsecase;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/api/v1/users")
public class UsersPublicController {
    private final GetUsersUsecase getUsersUsecase;
    private final CreateUserUsecase createUserUsecase;

    public UsersPublicController (final GetUsersUsecase getUsersUsecase, CreateUserUsecase createUserUsecase) {
        this.getUsersUsecase = getUsersUsecase;
        this.createUserUsecase = createUserUsecase;
    }

    //  Simple RBAC where only logged in admins are allowed to access get all users endpoint
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping
    public ResponseEntity<?> getUsers() {
        String email = Claims.getEmailFromJwt();
        log.info("Requester email is: " + email);
        return ApiResponse.successfulResponse("Get all users success", getUsersUsecase.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable final Long id) {
        return ApiResponse.successfulResponse("Get user details success", getUsersUsecase.getUserById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO req) {
        var result = createUserUsecase.createUser(req);
        return ApiResponse.successfulResponse("Create user success", result);
    }
}

