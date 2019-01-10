package pl.jedrik94.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jedrik94.demo.model.Customer;
import pl.jedrik94.demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.getCustomers();
    }
}
