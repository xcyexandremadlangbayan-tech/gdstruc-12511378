public class Card {
    private String name;
    private String[] ranks = {
        "Ace", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Jack",  "Queen", "King"
    };
    private String[] suits = {
        "Clubs", "Diamonds", "Hearts", "Spades"
    };

    public Card()
    {
        this.name = ranks[(int) (Math.random() * 13)] + " of " + suits[(int) (Math.random() * 4)];
    }

    public String getName()
    {
        return name;
    }
}
