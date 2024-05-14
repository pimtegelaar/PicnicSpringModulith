package tech.picnic.shortage;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tech.picnic.picking.ShortageEvent;

@Service
public class ShortageService {

  @EventListener
  public void notifyShortage(ShortageEvent event) throws InterruptedException {
    System.out.println("Notifying shortage of article " + event.articleId());
    Thread.sleep(1000);
    System.out.println("Handled shortage of article " + event.articleId());
  }
}
