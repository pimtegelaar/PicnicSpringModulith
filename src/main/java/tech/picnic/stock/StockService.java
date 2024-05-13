package tech.picnic.stock;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StockService  {

  private final StockRepository stockRepository;

  public int getStock(String articleId) {
    return stockRepository.getStock(articleId);
  }

  public boolean reduceStock(String articleId, int amount) {
    return stockRepository.reduceStock(articleId, amount);
  }

  public void addStock(String articleId, int amount) {
    stockRepository.addStock(articleId, amount);
  }
}
