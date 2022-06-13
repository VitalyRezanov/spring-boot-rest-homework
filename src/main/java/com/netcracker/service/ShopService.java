package com.netcracker.service;

import com.netcracker.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    public List<String> retrieveName(ShopRepository repository, String area){
        return repository.retrieveName(area);
    }
    public List<String> retrieveShopByDiscountCustomer(ShopRepository repository, String area, Integer discount1,
                                                             Integer discount2) {
        return repository.retrieveShopByDiscountCustomer(area, discount1, discount2);
    }
}
