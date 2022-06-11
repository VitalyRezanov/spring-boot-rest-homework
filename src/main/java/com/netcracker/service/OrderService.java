package com.netcracker.service;

import com.netcracker.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public List<String> retrieveDifferentMonth(OrderRepository repository){
        return repository.retrieveDifferentMonth();
    }
}