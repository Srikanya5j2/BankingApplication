package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.AccountHolder;
import com.springboot.main.repository.AccountHolderRepository;
@Service
public class AccountHolderService {
	
	@Autowired
	AccountHolderRepository accountHolderRepository;
	public AccountHolder insertAccountHolder(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		return accountHolderRepository.save(accountHolder);
	}
	
	public AccountHolder findById(int accountHolderId) throws InvalidIdException {
		Optional<AccountHolder> optional =  accountHolderRepository.findById(accountHolderId);
		if(!optional.isPresent()){
			throw new InvalidIdException("AccountHolder Invalid");
		}
		return optional.get();
	}

	public List<AccountHolder> findByAccountType(String accountType) {
		// TODO Auto-generated method stub
		return accountHolderRepository.findByAccountType(accountType);
	}
}
