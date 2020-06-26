package app.core.useCases.transaction;

import app.entities.Transaction;

import java.util.ArrayList;

import app.entities.Customer;
import app.entities.Product;
public abstract class TransactionRepository {
  public abstract ArrayList<Transaction> getTotalItemsSoldMonthly();
  public abstract ArrayList<Transaction> getTransactions();
  public abstract ArrayList<Transaction> getTransactionsByCustomer(Customer customer);
  public abstract Transaction createTransaction(Customer customer, Product product, int quantity);
}