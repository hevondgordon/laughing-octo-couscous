package app.core.useCases.inventory;

import app.entities.InventorySnapshot;

public class getInventorySnapshot {
  InventoryRepository inventoryRepository;
  public getInventorySnapshot(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public InventorySnapshot execute() {
    return this.inventoryRepository.getSnapshot();
  }
}