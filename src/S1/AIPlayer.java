package S1;

import java.util.*;

public class AIPlayer extends Player {
    @Override
    public Card playCard() {
        Random random = new Random();
        int index = (random.nextInt(this.getHandCards().size()));
//        System.out.println("AI隨機出牌：" + this.getHandCards().get(index).toString());
        Card card = this.getHandCards().get(index);
        this.getHandCards().remove(index);
        return card;
    }
}
