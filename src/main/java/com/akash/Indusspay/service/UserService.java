package com.akash.Indusspay.service;

import com.akash.Indusspay.exception.MyException;
import com.akash.Indusspay.exception.UserNotFoundException;
import com.akash.Indusspay.exception.ValidationException;
import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserBank;
import com.akash.Indusspay.repository.BankRepository;
import com.akash.Indusspay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    BankRepository bankRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(int id)throws Exception{
       User user= userRepo.findById(id).orElseThrow(()->new UserNotFoundException("No userId with such user present"));
       return user;
    }

    public User addUser(User user) throws Exception{


        UserBank bank = user.getUserBank();
        bank.setUserId(user.getUserId());
        user.setUserBank(bank);
        if(userRepo.findByEmail(user.getEmail())!=null)
           throw new ValidationException("Email already present");
        if(userRepo.findByPhone(user.getPhone())!=null)
            throw new ValidationException("Phone already present");

        if(bankRepo.findByAccountNumber(user.getUserBank().getAccountNumber())!=null)
            throw new ValidationException("Account Number already present");

       return userRepo.save(user);
    }
}
