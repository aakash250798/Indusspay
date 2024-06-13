package com.akash.Indusspay.repository;

import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<UserBank, Integer> {


    UserBank findByAccountNumber(String accountNumber);
}
