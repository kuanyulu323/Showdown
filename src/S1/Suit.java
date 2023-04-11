package S1;

public enum Suit {
    CLUB("\u2663"), DIAMOND("\u2666"), HEART("\u2665"), SPADE("\u2660");

    private final String symbol;

    private Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
