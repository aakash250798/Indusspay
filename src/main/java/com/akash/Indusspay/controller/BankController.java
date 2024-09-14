package com.akash.Indusspay.controller;

import com.akash.Indusspay.model.UserBank;
import com.akash.Indusspay.model.UserTxn;
import com.akash.Indusspay.service.BankService;
import com.akash.Indusspay.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService service;


    @GetMapping("/get/{id}/")
    public UserBank getById(@PathVariable int id){
        return service.getByid(id);
    }

    @PostMapping("/add")
    public UserBank add(@RequestBody UserBank bank){
        return service.add(bank);
    }


}
