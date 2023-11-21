package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.AccountHolder;
import com.springboot.main.service.AccountHolderService;

@RestController
@RequestMapping("/accountholder")
public class AccountHolderController {
	@Autowired
	private AccountHolderService accountHolderService;
	@PostMapping("/add")
	public AccountHolder insertAccountHolder(@RequestBody AccountHolder accountHolder) {
	   accountHolder= accountHolderService.insertAccountHolder(accountHolder);
	    return accountHolder;

}
	@GetMapping("/getAccountHoldersByType/{accountType}")
	public ResponseEntity<?> getAccountHoldersByType(@PathVariable("accountType") String accountType) {
	    try {
	        List<AccountHolder> accountHolders = accountHolderService.findByAccountType(accountType);
	        return ResponseEntity.ok().body(accountHolders);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

}
