package app.concrete;

import app.core.useCases.inventory.InventoryRepository;
import app.entities.Inventory;
import app.entities.InventoryItem;
import app.entities.InventorySnapshot;
import app.entities.InventorySummary;
import app.entities.Product;

import java.util.ArrayList;

public class ConcreteInventoryRepository extends InventoryRepository {
  public Inventory inventory;

  public ConcreteInventoryRepository() {
    super();
    this.inventory = new Inventory("StewyTech");
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
    return this.inventory.getInventoryItems();
  }

  @Override
  public InventorySummary getInventorySummary(ArrayList<InventoryItem> l) {
    int productCost = 0;
    for (InventoryItem inventoryItem : l) {
      productCost += (inventoryItem.product.price * inventoryItem.quantity);
    }
    return new InventorySummary(l.size(), productCost);
  }
  @Override
  public void addInventoryItem(InventoryItem inventoryItem) {
    this.inventory.addInventoryItem(inventoryItem);
  }

  @Override
  public InventoryItem removeItemsFromInventory(Product product, int quantity) {
    return this.inventory.removeFromInventory(product, quantity);
  }
}