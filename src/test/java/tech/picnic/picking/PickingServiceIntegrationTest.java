/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
