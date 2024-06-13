package com.akash.Indusspay.repository;

import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserTxn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxnRepository extends JpaRepository<UserTxn, Integer> {
}
