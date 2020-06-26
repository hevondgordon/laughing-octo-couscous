package app.entities;

public class Product {
  public String name;
  public double price;
  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String toString() {
    return "Price: " + this.price +"\n" + "Name:" + this.name;
  }
}