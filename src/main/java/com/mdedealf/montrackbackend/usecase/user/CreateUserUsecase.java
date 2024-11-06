package com.mdedealf.montrackbackend.usecase.user;

import com.mdedealf.montrackbackend.entity.Users;

public interface CreateUserUsecase {
    Users createUser(CreateUserRequestDTO req);
}
