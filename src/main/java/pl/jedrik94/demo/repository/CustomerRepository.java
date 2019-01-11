package pl.jedrik94.demo.repository;

import pl.jedrik94.demo.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
