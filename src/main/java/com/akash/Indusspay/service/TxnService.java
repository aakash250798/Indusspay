package com.akash.Indusspay.service;

import com.akash.Indusspay.exception.MyException;
import com.akash.Indusspay.exception.UserNotFoundException;
import com.akash.Indusspay.exception.ValidationException;
import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserTxn;
import com.akash.Indusspay.repository.TxnRepository;
import com.akash.Indusspay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TxnService {

    @Autowired
    TxnRepository repo;

    @Autowired
    UserRepository userRepo;



    public List<UserTxn> getAll(){
        return repo.findAll();
    }

    public UserTxn getById(int id){
        return repo.findById(id).get();
    }

    public UserTxn add(UserTxn txn, Integer id) throws Exception{
        System.out.println(txn +" "+ id);
        txn.setUserId(id);
        Integer txnId = randomGenerate();
        txn.setTxnId(txnId);
        if(txn.getAmount()<0)
            throw new ValidationException("Amount should be positive or Zero");
        txn.setUser(userRepo.findById(id).orElseThrow(()->new UserNotFoundException("Exception")));
        return repo.save(txn);
    }

    private Integer randomGenerate() {

        Random r = new Random();
        int low = 10000000;
        int high = 99999999;
        Integer result = r.nextInt(high-low) + low;
        return result;
    }


    public User getWithAmount(int userId, int ia, int fa) throws Exception{

        User user= userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("No userId with such user present"));
        List<UserTxn> list = user.getUserTxn().stream()
                .filter(e->(e.getAmount()>=ia && e.getAmount()<=fa))
                .collect(Collectors.toList());
        user.setUserTxn(list);
        return user;
    }

    public List<UserTxn> sortedOrderAmount() {

        List<UserTxn>list =repo.findAll();
        return
        list.stream().sorted(new Comparator<UserTxn>() {
            @Override
            public int compare(UserTxn o1, UserTxn o2) {
                return o1.getAmount()-o2.getAmount();
            }
        }).collect(Collectors.toList());
    }

    public Set<User> fetchAllUserData() {
        List<Integer> list =
        repo.findAll().stream().map(e->e.getUserId()).collect(Collectors.toList());
        return list.stream().map(e->userRepo.findById(e).get()).collect(Collectors.toSet());

    }
}
