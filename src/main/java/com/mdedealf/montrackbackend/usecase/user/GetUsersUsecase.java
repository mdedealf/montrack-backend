package com.mdedealf.montrackbackend.usecase.user;

import com.mdedealf.montrackbackend.entity.Users;

import java.util.List;

public interface GetUsersUsecase {
    List<Users> getAllUsers();
    Users getUserById(int id);
}
