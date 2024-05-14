package tech.picnic.picking;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import tech.picnic.stock.StockRepository;

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.STANDALONE)
@RequiredArgsConstructor
class PickingServiceIntegrationTest {

  private final PickingService pickingService;

  @MockBean private final PickingRepository pickingRepository;

  @MockBean private final StockRepository stockRepository;

  @Test
  void publishesOrderCompletion(Scenario scenario) {
    String articleId = "1";

    scenario
        .stimulate(() -> pickingService.pick(articleId, 20))
        .andWaitForEventOfType(ShortageEvent.class)
        .matchingMappedValue(ShortageEvent::articleId, articleId)
        .toArrive();
  }
}
