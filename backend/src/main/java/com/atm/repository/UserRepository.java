package com.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccNoAndPin(Long accNo, int pin);
}