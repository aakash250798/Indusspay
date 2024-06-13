package com.akash.Indusspay.controller;

import com.akash.Indusspay.model.User;
import com.akash.Indusspay.model.UserTxn;
import com.akash.Indusspay.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class TxnController {

    @Autowired
    TxnService service;


    @GetMapping("txn/get/{id}")
    public UserTxn getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("txn/add/{id}")
    public UserTxn add(@RequestBody UserTxn txn, @PathVariable Integer id) throws Exception{
        return service.add(txn, id);
    }


    @GetMapping("txn/amount/{initial_range}/{final_range}")
    public User getWithAmount(@RequestParam int userId, @PathVariable int initial_range, @PathVariable int final_range)throws Exception{
        return service.getWithAmount(userId, initial_range, final_range);
    }


    @GetMapping("sort/amount")
    public List<UserTxn> getAllAmountsSorted(){
        return service.sortedOrderAmount();
    }

    //this one was not clear to me so I made code of what I understood

    @GetMapping("/txn/get/details")
    public Set<User> fetchAllUserData(){
        return service.fetchAllUserData();
    }
}
