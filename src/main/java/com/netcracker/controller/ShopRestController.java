package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Shop;
import com.netcracker.repository.ShopRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import com.netcracker.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ShopRestController {
    @Autowired
    private ShopRepository repository;

    @Autowired
    private EntityCrudService<Shop> entityService;

    @Autowired
    private ShopService shopService;

    @GetMapping("/shops")
    public List<Shop> getAllShops() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/shops")
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return entityService.addEntity(shop, repository);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<DeleteResponse> deleteShop(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/shops/{id}")
    public ResponseEntity<Shop> patchShop(@PathVariable(value = "id") Integer id, @RequestBody Shop shop) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository, shop);
    }

    @PutMapping("/shops")
    public List<Shop> patchAllShops(@RequestBody List<Shop> shop) {
        return entityService.patchAllEntities(shop, repository);
    }
    @GetMapping("/shops/name")
    public List<String> getNameDiscount(@RequestParam String area) {
        return shopService.retrieveName(repository, area);
    }
    @GetMapping("/shops/get-shops-by-discount-not-area")
    public List<String> retrieveShopByDiscountCustomer(@RequestParam String notArea, @RequestParam Integer discount1,
                                                             @RequestParam Integer discount2) {
        return shopService.retrieveShopByDiscountCustomer(repository,notArea, discount1,discount2);
    }
}
