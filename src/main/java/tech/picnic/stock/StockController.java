package tech.picnic.stock;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {
  private final StockService stockService;

  @GetMapping("/{articleId}")
  public void getStock(@PathVariable String articleId) {
    stockService.getStock(articleId);
  }
}
