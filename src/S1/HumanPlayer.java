package S1;

import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public void playCard() {
        System.out.println("你的手牌有：" + getHandCardsToString());
        System.out.print("你想出哪一張呢？");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        while (index < 0 || index > getHandCards().size()){
            index = scanner.nextInt();
        }
        
    }
}
