package app.core.useCases.transaction;

import java.util.ArrayList;

import app.entities.Transaction;

public class getTransactions {
  TransactionRepository transactionRepository;
  public getTransactions(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public ArrayList<Transaction> execute() {
    return this.transactionRepository.getTransactions();
  }
}