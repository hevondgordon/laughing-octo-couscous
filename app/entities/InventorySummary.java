package app.entities;

public class InventorySummary {
  public int totalProducts;
  public int totalProductCost;
  public InventorySummary(int totalProducts, int totalProductCost) {
    this.totalProductCost = totalProductCost;
    this.totalProducts = totalProducts;
  }

}