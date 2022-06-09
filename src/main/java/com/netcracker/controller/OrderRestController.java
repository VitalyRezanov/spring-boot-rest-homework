package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Order;
import com.netcracker.repository.OrderRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class OrderRestController {
    @Autowired
    OrderRepository repository;

    @Autowired
    EntityCrudService<Order> entityService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return entityService.addEntity(order, repository);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<DeleteResponse> deleteOrder(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/orders/{id}")
    public Order patchOrder(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository);
    }

    @PutMapping("/orders")
    public List<Order> patchAllOrders(@RequestBody List<Order> order) {
        return entityService.patchAllEntities(order, repository);
    }
}
