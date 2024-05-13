package tech.picnic.replenishment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.picnic.stock.StockService;

@AllArgsConstructor
@Service
public class ReplenishmentService {
    private final StockService stockService;

    public void replenish(String articleId, int amount) {
        System.out.println("Replenishing article " + articleId + " with " + amount + " items");
        stockService.addStock(articleId, amount);
    }
}
