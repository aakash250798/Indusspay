package com.akash.Indusspay.service;

import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserBank;
import com.akash.Indusspay.repository.BankRepository;
import com.akash.Indusspay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    BankRepository repo;

    @Autowired
    UserRepository userRepo;

    public List<UserBank> getAll(){
        return repo.findAll();
    }
    public UserBank getByid(int id){
        return repo.findById(id).get();
    }

    public UserBank add(UserBank bank){
        User user= userRepo.findById(bank.getUserId()).get();
         //bank.setUser(user);
        return repo.save(bank);
    }

}
