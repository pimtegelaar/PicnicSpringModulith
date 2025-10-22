package tech.picnic.picking;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import tech.picnic.stock.StockService;

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.STANDALONE)
@RequiredArgsConstructor
class PickingServiceIntegrationTest {

  private final PickingService pickingService;

  @MockitoBean
  private final PickingRepository pickingRepository;

  @MockitoBean private final StockService stockService;

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
