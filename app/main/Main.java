package app.main;

import java.util.ArrayList;

import app.concrete.ConcreteCustomerRepository;
import app.concrete.ConcreteInventoryRepository;
import app.concrete.ConcreteTransactionRepository;
import app.core.useCases.customer.addCustomer;
import app.core.useCases.inventory.addInventoryItem;
import app.core.useCases.transaction.createTransaction;
import app.entities.Customer;
import app.entities.InventoryItem;
import app.entities.Product;

public class Main {
  public static void main(String[] args) {
    System.out.println("Add Customer");
    ConcreteCustomerRepository customerRepo = seedCustomers();
    ConcreteInventoryRepository inventoryRepo = seedInventory();
    // seedTransactions(customerRepo, inventoryRepo);
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
    return customerRepo;
  }

  public static ConcreteInventoryRepository seedInventory() {
    Product product1 = new Product(
      "Bag Juice",
      10.50
    );
    Product product2 = new Product(
      "Bread",
      10.50
    );
    Product product3 = new Product(
      "Bammy",
      10.50
    );

    InventoryItem inventoryItem1 = new InventoryItem(product1, 100);
    InventoryItem inventoryItem2 = new InventoryItem(product2, 100);
    InventoryItem inventoryItem3 = new InventoryItem(product3, 100);

    ConcreteInventoryRepository concreteInventoryRepository = new ConcreteInventoryRepository();
    addInventoryItem addInventoryItemCommad = new addInventoryItem(concreteInventoryRepository);
    addInventoryItemCommad.execute(inventoryItem1);
    // addInventoryItemCommad.execute(inventoryItem2);
    // addInventoryItemCommad.execute(inventoryItem3);
    return concreteInventoryRepository;
  }

  public static void seedTransactions(
    ConcreteCustomerRepository customerRepo, ConcreteInventoryRepository inventoryRepo) {
      ArrayList<Customer> customers = customerRepo.getTotalCustomers();
      ArrayList<InventoryItem> inventoryItems = inventoryRepo.getInventoryItems();
      ConcreteTransactionRepository transactionRepository = new ConcreteTransactionRepository();
      createTransaction createTransactionCommand = new createTransaction(transactionRepository);
      for (int i = 0; i < customers.size(); i++) {
        createTransactionCommand.execute(customers.get(i), inventoryItems.get(i).product,
        i, inventoryRepo.inventory);
      }
  }
}