package S1;

import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public Card playCard() {
        System.out.println("你的手牌有：");
        System.out.println(getHandCardsToString());
        System.out.print("你想出哪一張呢？");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        while (index < 0 || index > this.getHandCards().size()) {
            System.out.print("無法選擇對應的手牌");
            System.out.print("你想出哪一張呢？");
            index = scanner.nextInt();
        }
        Card card = this.getHandCards().get(index - 1);
        this.getHandCards().remove(index - 1);

        return card;
    }
}
