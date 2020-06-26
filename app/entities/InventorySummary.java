package app.entities;

public class InventorySummary {
  public int totalProducts;
  public int totalProductCost;
  public String lastUpdated;
  public InventorySummary(int totalProducts, int totalProductCost) {
    this.totalProductCost = totalProductCost;
    this.totalProducts = totalProducts;
    this.lastUpdated = this.getDateLastupdated();
  }

  public String getDateLastupdated() {
    return "yyyy/mm/dd";
  }
}