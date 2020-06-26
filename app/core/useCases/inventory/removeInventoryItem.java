package app.core.useCases.inventory;

import app.entities.InventoryItem;

public class removeInventoryItem {
  InventoryRepository inventoryRepository;
  public removeInventoryItem(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public void execute(InventoryItem inventoryItem) {
     this.inventoryRepository.removeItemFromInventory(inventoryItem);
  }
}