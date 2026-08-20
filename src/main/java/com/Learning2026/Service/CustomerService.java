package com.Learning2026.Service;


import com.Learning2026.Entity.User;
import com.Learning2026.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    UserRepository userRepository;

    public User CreateCustomer(User customer){


        return userRepository.save(customer);
    }

    public User getById(long id) {

        return userRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    public List<User> getByAddress(String address){

        return userRepository.findByAddress(address);
    }

    public List<User>getAll(){
        return userRepository.findAll();
    }

    public User updateCustomersName(long id,User customer ){
        User customer1=userRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid"));
        customer1.setName(customer.getName());
       return userRepository.save(customer1);
    }

    public boolean existByName(String name){
       // name="Sabzar Bhat";
      boolean exist=  userRepository.existsByName(name);
      if(exist){
          System.out.println("Welcome to booleann");
          return true;
      }
        System.out.println("not");
      return false;
    }

    public void DeletCustomerById(long id){
      User customer=  userRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));

      userRepository.delete(customer);

    }



}
