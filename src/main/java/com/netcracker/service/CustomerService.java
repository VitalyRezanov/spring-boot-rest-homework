package com.netcracker.service;

import com.netcracker.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public List<String> retrieveDifferentArea(CustomerRepository repository){
        return repository.retrieveDifferentArea();
    }
    public List<String> retrieveNameDiscount(CustomerRepository repository, String area){
        return repository.retrieveNameDiscount(area);
    }
}
