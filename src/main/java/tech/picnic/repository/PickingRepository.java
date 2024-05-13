package tech.picnic.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PickingRepository {
    public void pick(String articleId, int amount) {
        System.out.println("Picking " + amount + " of article " + articleId);
    }
}
