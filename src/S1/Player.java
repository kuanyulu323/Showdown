package S1;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private String name;

    private List<Card> handCards = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    public abstract void playCard();

    public String getHandCardsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getHandCards().size(); i++) {
            Card card = getHandCards().get(i);
            stringBuilder.append(i + 1).append(":").append(card.getSuit().getSymbol()).append(card.getRank().getRank());
        }
        return stringBuilder.toString();
    }

    public void drawCard(Deck deck) {
        if (deck.getCards().isEmpty()) {
            throw new IllegalArgumentException("沒牌了");
        }
        this.getHandCards().add(deck.getCards().get(0));
        deck.getCards().remove(0);
    }
}
