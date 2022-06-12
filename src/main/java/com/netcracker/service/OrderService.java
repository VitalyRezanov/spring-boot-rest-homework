package com.netcracker.service;

import com.netcracker.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public List<String> retrieveDifferentMonth(OrderRepository repository){
        return repository.retrieveDifferentMonth();
    }
    public List<String> retrieveNameShopAndCustomerFromOrder(OrderRepository repository){
        return repository.retrieveNameShopAndCustomerFromOrder();
    }
    public List<String> retrieveBookAndCustomerFromOrder(OrderRepository repository) {
        return repository.retrieveBookAndCustomerFromOrder();
    }
}
