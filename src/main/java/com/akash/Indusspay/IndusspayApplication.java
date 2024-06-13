package com.akash.Indusspay;

import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserBank;
import com.akash.Indusspay.model.UserTxn;
import com.akash.Indusspay.repository.BankRepository;
import com.akash.Indusspay.repository.TxnRepository;
import com.akash.Indusspay.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndusspayApplication {





	public static void main(String[] args) {
		SpringApplication.run(IndusspayApplication.class, args);
	}



}
