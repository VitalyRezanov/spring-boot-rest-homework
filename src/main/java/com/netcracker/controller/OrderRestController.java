package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.model.Order;
import com.netcracker.repository.OrderRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import com.netcracker.service.OrderService;
import io.swagger.v3.oas.annotations.OpenAPI30;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class OrderRestController {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private EntityCrudService<Order> entityService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return entityService.addEntity(order, repository);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<DeleteResponse> deleteOrder(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/orders/{id}")
    public ResponseEntity<Order> patchOrder(@PathVariable(value = "id") Integer id, @RequestBody Order order) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository, order);
    }

    @PutMapping("/orders")
    public List<Order> patchAllOrders(@RequestBody List<Order> order) {
        return entityService.patchAllEntities(order, repository);
    }
    @GetMapping("/orders/different-month")
    public List<String> getDifferentArea() {
        return orderService.retrieveDifferentMonth(repository);
    }

    @GetMapping("/orders/get-name-customer-shop")
    public List<String> retrieveNameShopAndCustomerFromOrder() {
        return orderService.retrieveNameShopAndCustomerFromOrder(repository);
    }

    @GetMapping("/orders/get-name-book-customer")
    public List<String> retrieveBookAndCustomerFromOrder() {
        return orderService.retrieveBookAndCustomerFromOrder(repository);
    }
}
