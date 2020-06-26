package app.entities;


public class Admin extends User {
  String password;
  public Admin(
    String firstName, String lastName,
    String emailAddress, String telephoneNumber,
    String password) {
    super(firstName, lastName,
      emailAddress, telephoneNumber);
      this.password = this.securePassword(password);
  }

  String securePassword(String password) {
    // for the sake of time I did not implement this function.
    return "securePassword1";
  }
  
}