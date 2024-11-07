package com.mdedealf.montrackbackend.usecase.user.impl;

import com.mdedealf.montrackbackend.entity.Roles;
import com.mdedealf.montrackbackend.entity.Users;
import com.mdedealf.montrackbackend.infrastructure.users.dto.CreateUserRequestDTO;
import com.mdedealf.montrackbackend.infrastructure.users.repository.RoleRepository;
import com.mdedealf.montrackbackend.infrastructure.users.repository.UsersRepository;
import com.mdedealf.montrackbackend.usecase.user.CreateUserUsecase;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log
@Service
public class CreateUserUsecaseImpl implements CreateUserUsecase {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public CreateUserUsecaseImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Users createUser(CreateUserRequestDTO req) {
        Users newUser = req.toEntity();
        newUser.setPasswordHash(passwordEncoder.encode(newUser.getPasswordHash()));

        Optional<Roles> defaultRole = roleRepository.findByName("USER");
        if(defaultRole.isPresent()) {
            newUser.getRoles().add(defaultRole.get());
        } else {
            throw new RuntimeException("Default role not found");
        }
        return usersRepository.save(newUser);
    }

    @Override
    public Users createUserWithEntity(Users req) {
        return null;
    }
}
