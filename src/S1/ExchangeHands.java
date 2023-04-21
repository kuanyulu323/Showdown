package S1;

import java.util.*;

public class ExchangeHands {

    private final Player sourcePlayer;

    private final Player targetPlayer;

    private int roundCount;

    public ExchangeHands(Player sourcePlayer, Player targetPlayer) {
        this.sourcePlayer = sourcePlayer;
        this.targetPlayer = targetPlayer;
        List<Card> tempCards = targetPlayer.getHandCards();
        targetPlayer.setHandCards(sourcePlayer.getHandCards());
        sourcePlayer.setHandCards(tempCards);
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public Player getSourcePlayer() {
        return sourcePlayer;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
