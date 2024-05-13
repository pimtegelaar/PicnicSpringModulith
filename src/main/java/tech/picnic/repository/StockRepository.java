package tech.picnic.repository;

import org.springframework.stereotype.Repository;

@Repository
public class StockRepository {
  public int getStock(String articleId) {
    System.out.println("Getting stock for article " + articleId);
    return 10;
  }

  public void addStock(String articleId, int amount) {
    System.out.println("Adding stock for article " + articleId + " with " + amount);
  }

  public boolean reduceStock(String articleId, int amount) {
    System.out.println("Reducing stock for article " + articleId + " with " + amount);
    return amount <= 10;
  }
}
