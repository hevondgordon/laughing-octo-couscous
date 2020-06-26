package app.concrete;

import app.core.useCases.customer.CustomerRepository;
import app.entities.Customer;
import app.entities.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

public class ConcreteCustomerRepository extends CustomerRepository {
  ArrayList<Customer> customerList;
  public ConcreteCustomerRepository() {
    super();
    this.customerList = new ArrayList<>();
  }

  public ArrayList<Customer> getRepeatCustomers(ArrayList<Transaction> transactions) {
    ArrayList<Customer> repeatCustomers = new ArrayList<>();
    HashMap<String, Boolean> seenBefore = new HashMap<>();
    for (int i = 0; i < transactions.size(); i++) {
      Transaction transaction = transactions.get(i);
      try {
        if(seenBefore.get(transaction.customer.emailAddress).equals(true)) {
          repeatCustomers.add(transaction.customer);
        }
      } catch (Exception e) {
        seenBefore.put(transaction.customer.emailAddress, true);
      }
    }
    return repeatCustomers;
  }
  public ArrayList<Customer> getTotalCustomers() {
    return this.customerList;
  }

  public Customer addCustomer(Customer customer) {
    this.customerList.add(customer);
    return customer;
  }
}