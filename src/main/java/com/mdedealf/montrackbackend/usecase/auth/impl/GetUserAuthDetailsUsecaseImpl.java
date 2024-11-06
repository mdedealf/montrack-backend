package com.mdedealf.montrackbackend.usecase.auth.impl;

import com.mdedealf.montrackbackend.common.exceptions.DataNotFoundException;
import com.mdedealf.montrackbackend.entity.Users;
import com.mdedealf.montrackbackend.infrastructure.users.dto.UserAuth;
import com.mdedealf.montrackbackend.infrastructure.users.repository.UsersRepository;
import com.mdedealf.montrackbackend.usecase.auth.GetUserAuthDetailsUsecase;
import lombok.extern.java.Log;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log
@Service
public class GetUserAuthDetailsUsecaseImpl implements GetUserAuthDetailsUsecase {
    private final UsersRepository usersRepository;

    public GetUserAuthDetailsUsecaseImpl (UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        Users existingUser = usersRepository.findByEmailContainsIgnoreCase(username).orElseThrow(() -> new DataNotFoundException("User not found with email: " + username));

        UserAuth userAuth = new UserAuth();
        userAuth.setUser(existingUser);
        return userAuth;
    }
}
