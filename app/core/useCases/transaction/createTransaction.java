package app.core.useCases.transaction;

import app.entities.Customer;
import app.entities.Product;
import app.entities.Transaction;

public class createTransaction {
  TransactionRepository transactionRepository;
  public createTransaction(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public Transaction execute(Customer customer, Product product, int quantity) {
    return this.transactionRepository.createTransaction(customer, product, quantity);
  }
}