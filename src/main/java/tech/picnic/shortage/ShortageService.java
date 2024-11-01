package tech.picnic.shortage;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import tech.picnic.picking.ShortageEvent;

@Service
public class ShortageService {

  @ApplicationModuleListener
  public void handleShortage(ShortageEvent event) throws InterruptedException {
    System.out.println("Received shortage of article " + event.articleId());
    Thread.sleep(1000);
    System.out.println("Handled shortage of article " + event.articleId());
  }
}
