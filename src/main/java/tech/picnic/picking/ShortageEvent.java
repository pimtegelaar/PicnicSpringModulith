package tech.picnic.picking;

import static tech.picnic.picking.AmqpConfig.SHORTAGES;

import org.springframework.modulith.events.Externalized;

@Externalized(SHORTAGES)
public record ShortageEvent(String articleId) {}
