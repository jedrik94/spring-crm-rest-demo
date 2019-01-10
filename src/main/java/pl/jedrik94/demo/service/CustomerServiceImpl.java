package pl.jedrik94.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jedrik94.demo.model.Customer;
import pl.jedrik94.demo.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Transactional
    @Override
    public List<Customer> searchCustomer(String searchName) {
        return customerRepository.searchCustomer(searchName);
    }
}
