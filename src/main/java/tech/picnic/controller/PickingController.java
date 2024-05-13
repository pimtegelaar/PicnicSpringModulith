package tech.picnic.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.picnic.service.PickingService;

@AllArgsConstructor
@RestController("/picking")
public class PickingController {
  private final PickingService pickingService;

  @PostMapping
  public void pick(PickingRequest pickingRequest) {
    pickingService.pick(pickingRequest.articleId(), pickingRequest.amount());
  }
}
