package app.core.useCases.transaction;

import java.util.ArrayList;

import app.entities.Transaction;
public class getTotalItemsSoldMonthly {
  TransactionRepository transactionRepository;
  public getTotalItemsSoldMonthly(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public ArrayList<Transaction> execute() {
    return this.transactionRepository.getTotalItemsSoldMonthly();
  }
}