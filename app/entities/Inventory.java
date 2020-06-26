package app.entities;

import java.util.ArrayList;

public class Inventory {
  ArrayList<InventoryItem> inventory;
  String companyName;
  public Inventory(ArrayList<InventoryItem> inventoryItems, String companyName) {
    this.inventory = inventoryItems;
    this.companyName = companyName;
  }

  public Inventory(String companyName) {
    this.companyName = companyName;
  }

  public ArrayList<InventoryItem> getInventoryItems() {
    return this.inventory;
  }

  public void addInventoryItems(ArrayList<InventoryItem> inventoryItems) {
    for (int i = 0; i < inventoryItems.size(); i++) {
      this.inventory.add(inventoryItems.get(i));
    }
  }

  public String getCompanyName() {
    return this.companyName;
  }
}