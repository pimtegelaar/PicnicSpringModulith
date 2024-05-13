package tech.picnic.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShortageService {

  @EventListener
  public void notifyShortage(ShortageEvent event) {
    System.out.println("Notifying shortage of article " + event.articleId());
  }
}
