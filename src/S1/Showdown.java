package S1;

import java.util.List;
import java.util.Scanner;

public class Showdown {

    private List<Player> players;

    private Deck deck;

    public Showdown(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public void nameHimself() {
        System.out.println("--- 取名字階段 ---");
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        for(Player player : players){
            if (player instanceof AIPlayer) {
                String aiPlayerName = "AI Player" + i++;
                System.out.println("AI命名為：" + aiPlayerName);
                player.setName(aiPlayerName);
            } else {
                System.out.print("命名：");
                player.setName(scanner.nextLine());
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }
}
