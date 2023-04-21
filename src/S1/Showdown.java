package S1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Showdown {

    private final List<Player> players;

    private final Deck deck;

    public Showdown(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public void nameHimself() {
        System.out.println("--- 取名字階段 ---");
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        List<String> humanNames = new ArrayList<>();
        for (Player player : players) {
            if (player instanceof AIPlayer) {
                String aiPlayerName = "AI Player" + i++;
                System.out.println("AI命名為：" + aiPlayerName);
                player.setName(aiPlayerName);
            } else {
                System.out.print("命名為：");
                String playerName = scanner.next();
                while (checkForDuplicateNames(humanNames, playerName)) {
                    System.out.print("無法命名與他人重複，請重新命名：");
                    playerName = scanner.next();
                }
                humanNames.add(playerName);
                player.setName(playerName);
            }
        }
    }

    private boolean checkForDuplicateNames(List<String> humanNames, String playerName) {
        return humanNames.stream().findFirst().filter(name -> name.equals(playerName)).isPresent();
    }

    public Deck getDeck() {
        return deck;
    }
}
