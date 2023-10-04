package com.devsuperior.curso.services;

import com.devsuperior.curso.entities.Order;
import com.devsuperior.curso.entities.User;
import com.devsuperior.curso.repositories.OrderRepository;
import com.devsuperior.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj= repository.findById(id);
        return obj.get();
    }
}
