package com.netcracker.service;

import com.netcracker.repository.CustomerRepository;
import com.netcracker.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    public List<String> retrieveName(ShopRepository repository, String area){
        return repository.retrieveName(area);
    }
}
