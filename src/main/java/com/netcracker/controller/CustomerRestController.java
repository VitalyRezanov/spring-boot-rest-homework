package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.CustomerService;
import com.netcracker.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private EntityCrudService<Customer> entityService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return entityService.getAllEntities(repository);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.getEntityById(id, repository);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return entityService.addEntity(customer, repository);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<DeleteResponse> deleteCustomer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return entityService.deleteEntity(id, repository);
    }

    @PatchMapping("/customers/{id}")
    public ResponseEntity<Customer> patchCustomer(@PathVariable(value = "id") Integer id, @RequestBody Customer customer) throws ResourceNotFoundException {
        return entityService.patchEntity(id, repository, customer);
    }

    @PutMapping("/customers")
    public List<Customer> patchAllCustomers(@RequestBody List<Customer> customers) {
        return entityService.patchAllEntities(customers, repository);
    }
    @GetMapping("/customers/different-area")
    public List<String> getDifferentArea() {
        return customerService.retrieveDifferentArea(repository);
    }

    @GetMapping("/customers/name-discount")
    public List<String> getNameDiscount(@RequestParam String area ) {
        return customerService.retrieveNameDiscount(repository, area);
    }
}
