package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.atm.model.User;
import com.atm.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/atm")
public class ATMController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public User login(@RequestParam Long accNo, @RequestParam int pin) {
        return service.login(accNo, pin);
    }

    @GetMapping("/balance/{accNo}")
    public double balance(@PathVariable Long accNo) {
        return service.getBalance(accNo);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accNo, @RequestParam double amt) {
        service.deposit(accNo, amt);
        return "Deposit Successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accNo, @RequestParam double amt) {
        service.withdraw(accNo, amt);
        return "Withdraw Successful";
    }
}