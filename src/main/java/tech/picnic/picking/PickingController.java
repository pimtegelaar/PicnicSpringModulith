package tech.picnic.picking;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/picking")
public class PickingController {
  private final PickingService pickingService;

  @PostMapping("/pick")
  public void pick(@RequestBody PickingRequest pickingRequest) {
    pickingService.pick(pickingRequest.articleId(), pickingRequest.amount());
  }

  @GetMapping("/trigger/{articleId}")
  public String triggerEvent(@PathVariable String articleId) {
    pickingService.triggerEvent(articleId);
    return "Triggered shortage event for article " + articleId;
  }
}
