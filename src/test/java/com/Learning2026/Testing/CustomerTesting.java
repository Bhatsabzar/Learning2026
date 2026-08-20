package com.Learning2026.Testing;

import com.Learning2026.Entity.User;
import com.Learning2026.Repository.UserRepository;
import com.Learning2026.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerTesting {

    @Mock
    UserRepository repository;

    @InjectMocks
    CustomerService service;

    @Test
    void customerTest() {

        User customer = new User();
        customer.setName("sabzar");
        customer.setId(1L);

        when(repository.save(customer)).thenReturn(customer);

      User result= service.CreateCustomer(customer);
      assertNotNull(result);

      assertEquals("sabzar",result.getName());
        verify(repository).save(customer);
    }

    void idTest(){
        User customer = new User();
        customer.setName("sabzar");
        customer.setId(10L);

        when(repository.findById(10L)).thenReturn(Optional.of(customer));
        User result=service.getById(10L);
        assertEquals("sabzar",result.getName());
    }

    @Test
    void testUpdate(){
        User customer = new User();
        customer.setName("sabzar");
        customer.setId(10L);

        User updated = new User();
        updated.setName("Bhat");

        when(repository.findById(10L)).thenReturn(Optional.of(customer));
        when(repository.save(customer)).thenReturn(customer);

        User result=  service.updateCustomersName(10L,updated);
        assertNotNull(result);
        assertEquals("Bhat", result.getName());

    }

    void deleteCust(){
        User customer = new User();
        customer.setName("sabzar");
        customer.setId(10L);

        when(repository.findById(customer.getId())).thenReturn(Optional.of(customer));

        service.DeletCustomerById(10L);

        when(repository.findById(customer.getId())).thenReturn(Optional.empty());

        service.DeletCustomerById(customer.getId());


    }


}