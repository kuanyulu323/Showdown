package S1;

import java.util.*;

public class AIPlayer extends Player {
    @Override
    public Card playCard() {
        Random random = new Random();
        int index = (random.nextInt(this.getHandCards().size()));
        Card card = this.getHandCards().get(index);
        this.getHandCards().remove(index);
        return card;
    }
}
