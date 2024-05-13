package tech.picnic.picking;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.picnic.stock.StockService;

@AllArgsConstructor
@Service
public class PickingService {
  private final PickingRepository pickingRepository;
  private final StockService stockService;

  private final ApplicationEventPublisher eventPublisher;

  @Transactional
  public void pick(String articleId, int amount) {
    if (stockService.reduceStock(articleId, amount)) {
      pickingRepository.pick(articleId, amount);
    } else {
      eventPublisher.publishEvent(new ShortageEvent(articleId));
    }
  }

  @Transactional
  public void triggerEvent(String articleId) {
    eventPublisher.publishEvent(new ShortageEvent(articleId));
  }
}
