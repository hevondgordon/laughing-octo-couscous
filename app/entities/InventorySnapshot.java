package app.entities;
import java.util.ArrayList;

public class InventorySnapshot {
  public ArrayList<InventoryItem> inventoryItems;
  public InventorySummary inventorySummary;

  public InventorySnapshot(ArrayList<InventoryItem> inventoryItems, InventorySummary inventorySummary) {
    this.inventoryItems = inventoryItems;
    this.inventorySummary = inventorySummary;
  }
}