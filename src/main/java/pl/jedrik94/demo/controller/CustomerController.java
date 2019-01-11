package pl.jedrik94.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jedrik94.demo.exception.CustomerNotFoundException;
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
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable int customerId) {
        final Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer with " + customerId + " id has not been found!");
        }
        return customer;
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer with " + customerId + " id has not been found!");
        }

        customerService.deleteCustomer(customerId);

        return "Operation successful. Customer with " + customerId + " has been deleted!";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);

        return customer;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }
}
