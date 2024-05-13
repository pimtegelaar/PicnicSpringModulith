package tech.picnic.service;

import org.springframework.stereotype.Service;

@Service
public class ReplenishmentService {
    public void replenish(String articleId, int amount) {
        System.out.println("Replenishing article " + articleId + " with " + amount + " items");
    }
}
