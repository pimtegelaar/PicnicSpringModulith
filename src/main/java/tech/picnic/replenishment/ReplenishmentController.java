package tech.picnic.replenishment;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/replenishment")
public class ReplenishmentController {

  private final ReplenishmentService replenishmentService;

  @PostMapping("/replenish")
  public void replenish(@RequestBody ReplenishmentRequest replenishmentRequest) {
    replenishmentService.replenish(replenishmentRequest.articleId(), replenishmentRequest.amount());
  }
}
