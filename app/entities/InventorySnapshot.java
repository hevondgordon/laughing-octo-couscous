package app.entities;
import java.util.ArrayList;

public class InventorySnapshot {
  ArrayList<InventoryItem> inventoryItems;
  InventorySummary inventorySummary;

  public InventorySnapshot(ArrayList<InventoryItem> inventoryItems, InventorySummary inventorySummary) {
    this.inventoryItems = inventoryItems;
    this.inventorySummary = inventorySummary;
  }
}