package tech.picnic.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tech.picnic.service.ReplenishmentService;

@AllArgsConstructor
@RestController("/replenishment")
public class ReplenishmentController {

    private final ReplenishmentService replenishmentService;

    public void replenish(ReplenishmentRequest replenishmentRequest) {
        replenishmentService.replenish(replenishmentRequest.articleId(), replenishmentRequest.amount());
    }
}
