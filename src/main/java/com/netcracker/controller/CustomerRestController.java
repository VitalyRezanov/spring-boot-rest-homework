package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {

    @Autowired
    CustomerRepository repository;

    @Autowired
    EntityCrudService<Customer> entityService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return entityService.addEntity(customer, repository);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<DeleteResponse> deleteCustomer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/customers/{id}")
    public Customer patchCustomer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository);
    }

    @PutMapping("/customers")
    public List<Customer> patchAllCustomers(@RequestBody List<Customer> customers) {
        return entityService.patchAllEntities(customers, repository);
    }
}
