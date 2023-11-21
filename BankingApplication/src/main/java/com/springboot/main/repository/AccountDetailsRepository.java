package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer> {

}
