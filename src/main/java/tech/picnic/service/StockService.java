package tech.picnic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.picnic.repository.StockRepository;

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
}
