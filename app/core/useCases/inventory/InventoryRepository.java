package app.core.useCases.inventory;

import app.entities.InventoryItem;
import app.entities.InventorySnapshot;
import app.entities.InventorySummary;
import app.entities.Product;

import java.util.ArrayList;

public abstract class InventoryRepository {
  public abstract InventorySnapshot getSnapshot();
  public abstract ArrayList<InventoryItem> getInventoryItems();
  public abstract InventorySummary getInventorySummary(
    ArrayList<InventoryItem> invItems
  );
  public abstract void addInventoryItem(InventoryItem inventoryItem);
  public abstract InventoryItem removeItemsFromInventory(Product product, int quantity);
}