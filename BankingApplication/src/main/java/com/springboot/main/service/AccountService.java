package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Account;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.repository.AccountRepository;
@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	public Account insertAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	
		public Account findById(int accountId) throws InvalidIdException {
			Optional<Account> optional =  accountRepository.findById(accountId);
			if(!optional.isPresent()){
				throw new InvalidIdException("AccountId Invalid");
			}
			return optional.get();
		}
	}


