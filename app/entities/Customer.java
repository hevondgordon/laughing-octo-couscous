package app.entities;

public class Customer extends User {
  public Customer(
    String firstName, String lastName,
    String emailAddress, String telephoneNumber) {
    super(firstName, lastName,
      emailAddress, telephoneNumber);
  }
}