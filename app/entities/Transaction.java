package app.entities;

import java.util.Date;

public class Transaction {
  public Customer customer;
  public Product product;
  public int quantity;
  public Date completedOn;
  public Transaction(Customer customer, Product product, int quantity) {
    this.customer = customer;
    this.product = product;
    this.quantity = quantity;
    this.completedOn = new Date();
  }
}