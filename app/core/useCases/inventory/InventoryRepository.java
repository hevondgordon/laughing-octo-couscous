package app.core.useCases.inventory;

import app.entities.InventoryItem;
import app.entities.InventorySnapshot;
import app.entities.InventorySummary;

import java.util.ArrayList;

public abstract class InventoryRepository {
  public abstract InventorySnapshot getSnapshot();
  public abstract ArrayList<InventoryItem> getInventoryItems();
  public abstract InventorySummary getInventorySummary(
    ArrayList<InventoryItem> invItems
  );
  public abstract InventoryItem addInventoryItem(InventoryItem inventoryItem);
  public abstract InventoryItem removeItemFromInventory(InventoryItem inventoryItem);
}