package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.BankExecutive;
import com.springboot.main.model.User;
import com.springboot.main.service.BankExecutiveService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/bankExecutives")
public class BankExecutiveController {

    @Autowired
    private BankExecutiveService bankExecutiveService;
    @Autowired
    private UserService userService;

    @PostMapping("/addBankExecutive")
    public BankExecutive addBankExecutive(@RequestBody BankExecutive bankExecutive) {
        
        User user = bankExecutive.getUser();
        
        
        user.setRole("EXECUTIVE");
        
      
        bankExecutive.setUser(user);

       
        User savedUser = userService.insert(user);
        bankExecutive.setUser(savedUser);

      
        return bankExecutiveService.insert(bankExecutive);
    }
}
