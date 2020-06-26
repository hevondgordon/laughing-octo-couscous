package app.main;

import java.util.ArrayList;
import java.util.Scanner;

import app.concrete.ConcreteCustomerRepository;
import app.concrete.ConcreteInventoryRepository;
import app.concrete.ConcreteTransactionRepository;
import app.core.useCases.customer.addCustomer;
import app.core.useCases.inventory.addInventoryItem;
import app.core.useCases.transaction.createTransaction;
import app.entities.Customer;
import app.entities.InventoryItem;
import app.entities.Product;
import app.entities.Transaction;

public class Main {
  public static void main(String[] args) {
    System.out.println("***********SEEDING APPLICATION***********");
    ConcreteCustomerRepository customerRepo = seedCustomers();
    ConcreteInventoryRepository inventoryRepo = seedInventory();
    ConcreteTransactionRepository transactionRepo = seedTransactions(customerRepo, inventoryRepo);
    System.out.println("***********COMPLETE SEEDING***********\n\n");
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("***********INSTRUCTIONS***************");
    System.out.println("[] - Enter 'src' to show all repeated customers");
    System.out.println("[] - Enter 'sal' to show all customers");
    System.out.println("[] - Enter 'tism' to show the total items sold monthly");
    System.out.println("[] - Enter 'soi' to show a snapshot of the inventory");
    System.out.println("[] - Enter 'lip' to list customers and items purchased");
    System.out.println("***********INSTRUCTIONS***************\n\n");
    String input = scanner.nextLine();
    switch(input) {
      case "src":
        ArrayList<Customer> repeatCustomers =
           customerRepo.getRepeatCustomers(transactionRepo.getTransactions());
        if(repeatCustomers.size() == 0) {
          System.out.println("There are no repeat customers at this time");
        } else {
          for (Customer customer : repeatCustomers) {
            System.out.println(customer.firstName+" " + customer.lastName + " has done business with us multiple times");
          }
        }
        input = scanner.nextLine();
      case "sac":
        ArrayList<Customer> customers = customerRepo.getTotalCustomers();
        for (Customer customer : customers) {
          System.out.println(
            customer.firstName+ " " + customer.lastName + "- " + customer.emailAddress
          );
        }
        input = scanner.nextLine();
      case "tism":
        ArrayList<Transaction> transactions = transactionRepo.getTotalItemsSoldMonthly();
        double total = 0;
        for (Transaction transaction : transactions) {
          total += (transaction.quantity * transaction.product.price);
          System.out.println(
            transaction.customer.firstName + " " + transaction.customer.lastName + " bought " + transaction.quantity + " " + transaction.product.name + "\ntotal: " + total
          );
        }
        input = scanner.nextLine();
      case "soi":
        input = scanner.nextLine();
      case "lip":
        input = scanner.nextLine();
      default:
        input = scanner.nextLine();
    }
    scanner.close();
  }

  public static ConcreteCustomerRepository seedCustomers() {
    Customer customer1 = new Customer(
       "Test",  "User 1",
       "test@user1.com",  "876-123-4567"
    );
    Customer customer2 = new Customer(
       "Test",  "User 2",
       "test@user2.com",  "876-456-4567"
    );
    Customer customer3 = new Customer(
       "Test",  "User 3",
       "test@user3.com",  "876-789-4567"
    );
    ConcreteCustomerRepository customerRepo = new ConcreteCustomerRepository();
    addCustomer addCustomerCommand = new addCustomer(customerRepo);
    addCustomerCommand.execute(customer1);
    addCustomerCommand.execute(customer2);
    addCustomerCommand.execute(customer3);
    System.out.println("Added 3 Customers");
    return customerRepo;
  }

  public static ConcreteInventoryRepository seedInventory() {
    Product product1 = new Product(
      "Bag Juice",
      10.50
    );
    Product product2 = new Product(
      "Bread",
      0.50
    );
    Product product3 = new Product(
      "Bammy",
      200.78
    );

    InventoryItem inventoryItem1 = new InventoryItem(product1, 100);
    InventoryItem inventoryItem2 = new InventoryItem(product2, 100);
    InventoryItem inventoryItem3 = new InventoryItem(product3, 100);

    ConcreteInventoryRepository concreteInventoryRepository = new ConcreteInventoryRepository("StewyTech");
    addInventoryItem addInventoryItemCommad = new addInventoryItem(concreteInventoryRepository);
    addInventoryItemCommad.execute(inventoryItem1);
    addInventoryItemCommad.execute(inventoryItem2);
    addInventoryItemCommad.execute(inventoryItem3);
    System.out.println("Added " + inventoryItem1.quantity+ " "+ inventoryItem1.product.name + "@" + inventoryItem1.product.price);
    System.out.println("Added " + inventoryItem2.quantity+ " "+ inventoryItem2.product.name + "@" + inventoryItem2.product.price);
    System.out.println("Added " + inventoryItem3.quantity+ " "+ inventoryItem3.product.name + "@" + inventoryItem3.product.price);
    return concreteInventoryRepository;
  }

  public static ConcreteTransactionRepository seedTransactions(
    ConcreteCustomerRepository customerRepo, ConcreteInventoryRepository inventoryRepo) {
      ArrayList<Customer> customers = customerRepo.getTotalCustomers();
      ArrayList<InventoryItem> inventoryItems = inventoryRepo.getInventoryItems();
      ConcreteTransactionRepository transactionRepository = new ConcreteTransactionRepository(inventoryRepo);
      createTransaction createTransactionCommand = new createTransaction(transactionRepository);
      for (int i = 1; i < customers.size(); i++) {
        System.out.println(
          customers.get(i).emailAddress + " bought " + (i+1) + " " + inventoryItems.get(i).product.name + "@ " + inventoryItems.get(i).product.price
        );
        createTransactionCommand.execute(customers.get(i), inventoryItems.get(i).product,
        i);
      }
      // create transaction by user that has alrady made a purchase
      createTransactionCommand.execute(customers.get(1), inventoryItems.get(1).product,
        10);
    return transactionRepository;
  }
}