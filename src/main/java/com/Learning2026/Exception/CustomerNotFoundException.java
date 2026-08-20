package com.Learning2026.Exception;

public class CustomerNotFoundException extends RuntimeException{
   public CustomerNotFoundException(long custId){
        super("CustomerNotFound"+custId);
    }
}
