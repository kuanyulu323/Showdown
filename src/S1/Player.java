package S1;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private String name;

    private List<Card> handCards = new ArrayList<>();

    private ExchangeHands exchangeHands;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ExchangeHands getExchangeHands() {
        return exchangeHands;
    }

    public void setExchangeHands(ExchangeHands exchangeHands) {
        this.exchangeHands = exchangeHands;
    }

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

    public abstract Card playCard();

    public String getHandCardsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getHandCards().size(); i++) {
            Card card = getHandCards().get(i);
            stringBuilder.append(i + 1).append(":").append(card.getSuit().getSymbol()).append(card.getRank().getRank()).append('\n');
        }
        return stringBuilder.toString();
    }

}
