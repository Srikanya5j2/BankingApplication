package com.springboot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>  {

	List<AccountHolder> findByAccountType(String accountType);

}
