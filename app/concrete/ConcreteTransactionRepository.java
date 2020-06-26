package app.concrete;

import app.core.useCases.transaction.TransactionRepository;
import app.entities.Transaction;
import app.entities.Customer;
import app.entities.InventoryItem;
import app.entities.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ConcreteTransactionRepository extends TransactionRepository {
  ArrayList<Transaction> transactions;
  ConcreteInventoryRepository inventoryRepository;
  public ConcreteTransactionRepository(ConcreteInventoryRepository concreteInventoryRepository) {
    super();
    this.transactions = new ArrayList<>();
    this.inventoryRepository = concreteInventoryRepository;
  }
  public ArrayList<Transaction> getTotalItemsSoldMonthly() {
    ArrayList<Transaction> transactions = new ArrayList<>();
    for (int i = 0; i < this.transactions.size(); i++) {
      Transaction transaction = this.transactions.get(i);
      Calendar cal = Calendar.getInstance();
      cal.setTime(transaction.completedOn);
      int transactionMonth = cal.get(Calendar.MONTH);
      cal.setTime(new Date());
      int currentMonth = cal.get(Calendar.MONTH);
      if (transactionMonth == currentMonth) {
        transactions.add(transaction);
      }
    }
    return transactions;
  }

  public ArrayList<Transaction> getTransactions() {
    return this.transactions;
  }

  public ArrayList<Transaction> getTransactionsByCustomer(Customer customer) {
    ArrayList<Transaction> transactions = new ArrayList<>();
    for (int i = 0; i < this.transactions.size(); i++) {
      Transaction transaction = this.transactions.get(i);
      if(transaction.customer.emailAddress.compareTo(customer.emailAddress) == 0) {
        transactions.add(transaction);
      }
    }
    return transactions;
  }

  public Transaction createTransaction(Customer customer, Product product,
    int quantity) {
    Transaction transaction = new Transaction(customer, product, quantity);
    this.transactions.add(transaction);
    InventoryItem inventoryItem = new InventoryItem(product, quantity);
    inventoryRepository.removeItemFromInventory(inventoryItem);
    return transaction;
  }
}