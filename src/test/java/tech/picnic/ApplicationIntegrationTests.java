package tech.picnic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.picnic.picking.PickingService;

@SpringBootTest
class ApplicationIntegrationTests {

  @Autowired PickingService pickingService;

  @Test
  void completesOrder() {
    pickingService.pick("1", 2);
  }
}
