package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Shop;
import com.netcracker.repository.ShopRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ShopRestController {
    @Autowired
    ShopRepository repository;

    @Autowired
    EntityCrudService<Shop> entityService;

    @GetMapping("/shops")
    public List<Shop> getAllShops() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/shops")
    public Shop addShop(@RequestBody Shop shop) {
        return entityService.addEntity(shop, repository);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<DeleteResponse> deleteShop(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/shops/{id}")
    public Shop patchShop(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository);
    }

    @PutMapping("/shops")
    public List<Shop> patchAllShops(@RequestBody List<Shop> shop) {
        return entityService.patchAllEntities(shop, repository);
    }
}
