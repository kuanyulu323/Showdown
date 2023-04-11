package S1;

public enum Rank {
    DEUCE("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"), 
    SIX("6"), 
    SEVEN("7"),
    EIGHT("8"), 
    NINE("9"), 
    TEN("10"), 
    JACK("J"), 
    QUEEN("Q"), 
    KING("K"), 
    ACE("A"),
    ;
    

    Rank(String rank) {
        this.rank = rank;
    }

    private final String rank;

    public String getRank() {
        return rank;
    }
}
