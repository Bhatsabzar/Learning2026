package com.Learning2026.Controller;



import com.Learning2026.Entity.User;
import com.Learning2026.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CustomerController {


    @Autowired
    CustomerService service;

    @GetMapping("/getall")
    public List<User>getAll(){
        return service.getAll();
    }


    @GetMapping("/get/{address}")
    public List<User> getCustomersByAddress(@PathVariable String address){
        return service.getByAddress(address);
    }


    @PatchMapping("/update/{id}")
    public User updateCustomersName(@PathVariable long id, @RequestBody User customer ){
       return service.updateCustomersName(id,customer);
    }

    @GetMapping("/get")
    public boolean existByName(String name){
        name="Sabzar Bhat";
      return   service.existByName(name);
    }

    @GetMapping("/getcust/{id}")
    public ResponseEntity<User> getCustomerById(@PathVariable long id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @GetMapping("/check")
    public String Check(){
        return "Welcome To Pahalgam";
    }


    @GetMapping("/app")
    public String CheckMyApplication(){

        return "Welcome To my new deployed Application";
    }


}
