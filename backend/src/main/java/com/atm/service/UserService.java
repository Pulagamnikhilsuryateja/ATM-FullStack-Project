package com.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atm.model.User;
import com.atm.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(Long accNo, int pin) {
        return repo.findByAccNoAndPin(accNo, pin);
    }

    public double getBalance(Long accNo) {
        return repo.findById(accNo).orElseThrow().getBalance();
    }

    public void deposit(Long accNo, double amt) {
        User user = repo.findById(accNo).orElseThrow();
        user.setBalance(user.getBalance() + amt);
        repo.save(user);
    }

    public void withdraw(Long accNo, double amt) {
        User user = repo.findById(accNo).orElseThrow();

        if (user.getBalance() < amt) {
            throw new RuntimeException("Insufficient Balance");
        }

        user.setBalance(user.getBalance() - amt);
        repo.save(user);
    }
}