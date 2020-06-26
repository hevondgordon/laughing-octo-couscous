package app.entities;

public class User {
  public String firstName;
  public String lastName;
  public String emailAddress;
  public String password;
  public String telephoneNumber;
  public User(
    String firstName, String lastName,
    String emailAddress,
    String telephoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.telephoneNumber = telephoneNumber;
  }
}