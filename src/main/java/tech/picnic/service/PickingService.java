package tech.picnic.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tech.picnic.repository.PickingRepository;

@AllArgsConstructor
@Service
public class PickingService {
  private final PickingRepository pickingRepository;
  private final StockService stockService;

  private final ApplicationEventPublisher eventPublisher;

  public void pick(String articleId, int amount) {
    if (stockService.reduceStock(articleId, amount)) {
      pickingRepository.pick(articleId, amount);
    } else {
      eventPublisher.publishEvent(new ShortageEvent(articleId));
    }
  }
}
