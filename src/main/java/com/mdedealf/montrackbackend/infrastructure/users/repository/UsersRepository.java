package com.mdedealf.montrackbackend.infrastructure.users.repository;

import com.mdedealf.montrackbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailContainsIgnoreCase(String email);
}
