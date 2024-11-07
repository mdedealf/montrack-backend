package com.mdedealf.montrackbackend.usecase.user.impl;

import com.mdedealf.montrackbackend.common.exceptions.DataNotFoundException;
import com.mdedealf.montrackbackend.entity.Users;
import com.mdedealf.montrackbackend.infrastructure.users.repository.UsersRepository;
import com.mdedealf.montrackbackend.usecase.user.GetUsersUsecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserUsecaseImpl implements GetUsersUsecase {
    private final UsersRepository usersRepository;

    public GetUserUsecaseImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        var foundUser = usersRepository.findById(id);
        if(foundUser.isEmpty()) {
            throw new DataNotFoundException("User not found");
        }
        return foundUser.get();
    }
}
