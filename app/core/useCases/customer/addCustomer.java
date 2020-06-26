package app.core.useCases.customer;

import app.entities.Customer;

public class addCustomer {
  CustomerRepository customerRepository;
  public addCustomer(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer execute(Customer customer) {
    return this.customerRepository.addCustomer(customer);
  }
}