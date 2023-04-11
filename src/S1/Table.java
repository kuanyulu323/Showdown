package S1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {


    public static void main(String[] args) {
        System.out.println("--- 遊戲開始 ---");
        System.out.print("此款遊戲支援四位玩家，請輸入需要幾名電腦玩家：");
        Scanner scanner = new Scanner(System.in);
        int playerCount = scanner.nextInt();

        while (playerCount < 0 || playerCount > 4) {
            System.out.print("輸入不可輸入少於0或超過4，請重新輸入：");
            playerCount = scanner.nextInt();
        }
        List<Player> players = new ArrayList<>(4);
        for (int i = 0; i < 4 - playerCount; i++) {
            Player player = new HumanPlayer();
            players.add(player);
        }
        for (int i = 1; i <= playerCount; i++) {
            Player player = new AIPlayer();
            players.add(player);
        }

        Showdown showdown = new Showdown(players, new Deck());
        showdown.nameHimself();
        Deck deck = showdown.getDeck();
        deck.shuffle();

        for (int i = 1; i <= 13; i++) {
            for (Player player : players) {
                player.getHandCards().add(deck.drawCard());
            }
        }

        System.out.println("123");
//        System.out.println(Rank.DEUCE.getRank());
//        System.out.println(new Deck().getCards().get(0).toString());
//        System.out.println(Rank.ACE.compareTo(Rank.DEUCE));
//        System.out.println(Rank.DEUCE.compareTo(Rank.THREE));
    }

}
