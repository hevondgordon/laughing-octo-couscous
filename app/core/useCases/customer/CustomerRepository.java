package app.core.useCases.customer;

import app.entities.Customer;
import app.entities.Transaction;
import java.util.ArrayList;

public abstract class CustomerRepository {
  public abstract ArrayList<Customer> getRepeatCustomers(ArrayList<Transaction> transactions);
  public abstract ArrayList<Customer> getTotalCustomers();
  public abstract Customer addCustomer(Customer customer);
}