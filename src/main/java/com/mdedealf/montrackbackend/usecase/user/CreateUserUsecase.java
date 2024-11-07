package com.mdedealf.montrackbackend.usecase.user;

import com.mdedealf.montrackbackend.entity.Users;
import com.mdedealf.montrackbackend.infrastructure.users.dto.CreateUserRequestDTO;

import java.util.List;

public interface CreateUserUsecase {
    Users createUser(CreateUserRequestDTO req);
    Users createUserWithEntity(Users req);
}
