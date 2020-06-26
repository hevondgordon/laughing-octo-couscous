package app.concrete;

import app.core.useCases.inventory.InventoryRepository;
import app.entities.InventoryItem;
import app.entities.InventorySnapshot;
import app.entities.InventorySummary;

import java.util.ArrayList;

public class ConcreteInventoryRepository extends InventoryRepository {
  public ArrayList<InventoryItem> inventory;

  public ConcreteInventoryRepository(String inventoryName) {
    super();
    this.inventory = new ArrayList<>();
  }

  @Override
  public InventorySnapshot getSnapshot() {
    ArrayList<InventoryItem> invItems = this.getInventoryItems();
    InventorySummary invSummary = this.getInventorySummary(invItems);
    InventorySnapshot summary = new InventorySnapshot(invItems, invSummary);
    return summary;
  }

  @Override
  public ArrayList<InventoryItem> getInventoryItems() {
    return this.inventory;
  }

  @Override
  public InventorySummary getInventorySummary(ArrayList<InventoryItem> l) {
    int productCost = 0;
    int totalProducts = 0;
    for (InventoryItem inventoryItem : l) {
      productCost += (inventoryItem.product.price * inventoryItem.quantity);
      totalProducts += inventoryItem.quantity;
    }
    return new InventorySummary(totalProducts, productCost);
  }
  @Override
  public void addInventoryItem(InventoryItem inventoryItem) {
    this.inventory.add(inventoryItem);
  }

  @Override
  public InventoryItem removeItemFromInventory(InventoryItem inventoryItem) {
    InventoryItem removed = null;
    for (InventoryItem _inventoryItem : inventory) {
      if(_inventoryItem.product.name.compareTo(inventoryItem.product.name) == 0 &&
      _inventoryItem.quantity > inventoryItem.quantity) {
        _inventoryItem.quantity -= inventoryItem.quantity;
        removed = _inventoryItem;
      }
    }
    return removed;
  }
}