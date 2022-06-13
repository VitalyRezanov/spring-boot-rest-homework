package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Order;
import com.netcracker.repository.OrderRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import com.netcracker.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class OrderController {
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

    @GetMapping("/orders/get-order-sum")
    public List<String> retrieveOrderBySum(@RequestParam Double sum) {
        return orderService.retrieveOrderLessSum(repository, sum);
    }

    @GetMapping("/orders/get-order-by-area-shop-customer")
    public List<String> retrieveOrderByAreaShopAndCustomer(@RequestParam Integer id,@RequestParam Date date) {
        return orderService.retrieveOrderByAreaShopAndCustomer(repository, id,date);
    }
}
