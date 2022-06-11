package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.EntityCrudService;
import com.netcracker.service.FileLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/native")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @Autowired
    EntityCrudService<Customer> entityService;

    @Autowired
    FileLoadService<Customer> fileLoadService;

    //Add one entity
    @GetMapping("/add-customer")
    public String addCustomer(Model model) {
        model.addAttribute("addCustomerAttribute", new Customer());
        return "addCustomer";
    }

    @PostMapping("/add-customer")
    public String addCustomerSubmit(@ModelAttribute Customer customer, Model model) {
        ResponseEntity<Customer> entity = entityService.addEntity(customer, repository);
        model.addAttribute("ResponseAddCustomerAttribute", entity);
        return "addCustomerPost";
    }
    //Get all
    @GetMapping("/get-all-entities")
    public String getAllCustomers(Model model) {
        List<Customer> entities = entityService.getAllEntities(repository);
        model.addAttribute("getAllEntitiesAttribute", entities);
        return "getAllEntities";
    }

    //Get By id
    @GetMapping("/get-entity")
    public String getCustomer(Model model) {
        model.addAttribute("getEntityAttribute", new Customer());
        return "getEntity";
    }

    @PostMapping("/get-entity")
    public String getCustomerSubmit(@ModelAttribute Customer customer, Model model) throws ResourceNotFoundException {
        ResponseEntity<Customer> entity = entityService.getEntityById(customer.getId(), repository);
        model.addAttribute("ResponseGetEntityAttribute", entity);
        return "getEntityPost";
    }
    //Delete by id
    @GetMapping("/delete-entity")
    public String deleteCustomer(Model model) {
        model.addAttribute("getEntityAttribute", new Customer());
        return "getEntity";
    }

    @PostMapping("/delete-entity")
    public String deleteCustomerSubmit(@ModelAttribute Customer customer, Model model) throws ResourceNotFoundException {
        ResponseEntity<DeleteResponse> entity = entityService.deleteEntity(customer.getId(), repository);
        model.addAttribute("ResponseGetEntityAttribute", entity);
        return "getEntityPost";
    }
    //Patch
    @GetMapping("/patch-entity")
    public String patchCustomer(Model model) {
        model.addAttribute("addCustomerAttribute", new Customer());
        return "addCustomer";
    }

    @PostMapping("/patch-entity")
    public String patchCustomerSubmit(@ModelAttribute Customer customer, Model model) throws ResourceNotFoundException {
        ResponseEntity<Customer> entity = entityService.patchEntity(customer.getId(), repository, customer);
        model.addAttribute("ResponseAddCustomerAttribute", entity);
        return "addCustomerPost";
    }
    @GetMapping("/patch-all-entities")
    public String fileUpload(Model model) {
        return "patchAllEntities";
    }

    @PostMapping("/patch-all-entities")
    public String fileUploadPost(@RequestParam("file") MultipartFile file) {
        List<Customer> customers = fileLoadService.uploadFile(file);
        entityService.patchAllEntities(customers, repository);
        return "patchAllEntitiesPost";
    }
}
