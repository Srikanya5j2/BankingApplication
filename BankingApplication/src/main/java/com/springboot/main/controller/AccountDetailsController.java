package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Account;
import com.springboot.main.model.AccountDetails;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.model.BankExecutive;
import com.springboot.main.service.AccountDetailsService;
import com.springboot.main.service.AccountHolderService;
import com.springboot.main.service.AccountService;
import com.springboot.main.service.BankExecutiveService;

@RestController
@RequestMapping("/accountDetails")
public class AccountDetailsController {

    @Autowired
    private AccountDetailsService accountDetailsService;
    @Autowired
    private AccountHolderService accountHolderService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BankExecutiveService bankExecutiveService;

    @PostMapping("/addAccountDetails/{accountHolderId}/{accountId}/{bankExecutiveId}")
    public ResponseEntity<?> addAccountDetails(@RequestBody AccountDetails accountDetails,
            @PathVariable("accountHolderId") int accountHolderId,
            @PathVariable("accountId") int accountId,
            @PathVariable("bankExecutiveId") int bankExecutiveId) {
        try {
            /* Fetch account holder, account, and bank executive objects from the database using IDs */
            AccountHolder accountHolder = accountHolderService.findById(accountHolderId);
            Account account = accountService.findById(accountId);
            BankExecutive bankExecutive = bankExecutiveService.findById(bankExecutiveId);

            accountDetails.setAccountHolder(accountHolder);
            accountDetails.setAccount(account);
            accountDetails.setBankExecutive(bankExecutive);

            accountDetails = accountDetailsService.addAccountDetails(accountDetails);

            return ResponseEntity.ok().body(accountDetails);
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
}

