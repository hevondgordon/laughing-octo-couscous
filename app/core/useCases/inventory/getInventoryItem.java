package app.core.useCases.inventory;

import app.entities.InventoryItem;
import java.util.ArrayList;

public class getInventoryItem {
  InventoryRepository inventoryRepository;
  public getInventoryItem(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public ArrayList<InventoryItem> execute() {
    return this.inventoryRepository.getInventoryItems();
  }
}