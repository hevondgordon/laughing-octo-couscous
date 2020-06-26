package app.core.useCases.customer;

import app.entities.Customer;
import app.entities.Transaction;

import java.util.ArrayList;

public class getAllCustomers {
  CustomerRepository customerRepository;
  public getAllCustomers(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public ArrayList<Customer> execute(ArrayList<Transaction> transactions) {
    return this.customerRepository.getTotalCustomers();
  }
}