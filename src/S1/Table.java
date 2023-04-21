package S1;

import java.util.*;

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

        //round
        for (int i = 1; i <= 13; i++) {
            Round round = new Round();
            for (Player player : players) {
                if (player instanceof HumanPlayer && player.getExchangeHands() == null) {
                    System.out.println("你要交換手牌嗎？ yes or no");
                    String yesOrNo = scanner.nextLine().toLowerCase();
                    while (!yesOrNo.equals("yes") && !yesOrNo.equals("no")) {
                        System.out.println("只能回答yes or no");
                        yesOrNo = scanner.nextLine().toLowerCase();
                    }
                    if (yesOrNo.equals("yes")) {
                        System.out.println("你要跟誰交換？");
                        for (Player player1 : players) {
                            if (player1 == player) {
                                continue;
                            }
                            System.out.println(player1.getName());
                        }
                        String targetPlayerName = scanner.nextLine();
                        while (!verifyName(players, player, targetPlayerName)) {
                            System.out.println("名字輸入錯誤，請再輸入一次：");
                            targetPlayerName = scanner.nextLine();
                        }
                    }
                }
                Card card = player.playCard();
                round.getPlayerCardMap().put(player, card);

                ExchangeHands exchangeHands = player.getExchangeHands();
                if (exchangeHands != null) {
                    exchangeHands.setRoundCount(exchangeHands.getRoundCount() + 1);
                    if (exchangeHands.getRoundCount() == 3) {
                        List<Card> tempCards = exchangeHands.getSourcePlayer().getHandCards();
                        exchangeHands.getSourcePlayer().setHandCards(exchangeHands.getTargetPlayer().getHandCards());
                        exchangeHands.getTargetPlayer().setHandCards(tempCards);
                    }
                }
            }
            Player maxPlayer = players.get(0);
            Card maxCard = round.getPlayerCardMap().get(maxPlayer);
            for (Map.Entry<Player, Card> entry : round.getPlayerCardMap().entrySet()) {
                Card card = entry.getValue();
                Player player = entry.getKey();
                System.out.println("玩家：" + player.getName() + ", 打出：" + card.toString());
                if (card.getRank().compareTo(maxCard.getRank()) > 0) {
                    maxPlayer = player;
                    maxCard = card;
                } else if (card.getRank().compareTo(maxCard.getRank()) == 0
                        && card.getSuit().compareTo(maxCard.getSuit()) > 0) {
                    maxPlayer = player;
                    maxCard = card;
                }
            }
            System.out.println("本輪獲勝的是：" + maxPlayer.getName());
            maxPlayer.setScore(maxPlayer.getScore() + 1);
        }

        Player maxScorePlayer = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getScore() > maxScorePlayer.getScore()) {
                maxScorePlayer = player;
            }
        }

        System.out.println("分數最高的玩家為：" + maxScorePlayer + ", 分數為：" + maxScorePlayer.getScore());


//        System.out.println(Rank.DEUCE.getRank());
//        System.out.println(new Deck().getCards().get(0).toString());
//        System.out.println(Rank.ACE.compareTo(Rank.DEUCE));
//        System.out.println(Rank.DEUCE.compareTo(Rank.THREE));
    }

    private static boolean verifyName(List<Player> players, Player sourcePlayer, String name) {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                ExchangeHands exchangeHands = new ExchangeHands(sourcePlayer, player);
                sourcePlayer.setExchangeHands(exchangeHands);
                return true;
            }
        }
        return false;
    }

}
