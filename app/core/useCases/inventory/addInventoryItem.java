package app.core.useCases.inventory;

import app.entities.InventoryItem;

public class addInventoryItem {
  InventoryRepository inventoryRepository;
  public addInventoryItem(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public void execute(InventoryItem inventoryItem) {
     this.inventoryRepository.addInventoryItem(inventoryItem);
  }
}
