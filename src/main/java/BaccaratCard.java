// TODO: Implement the BaccaratCard class in this file

public class BaccaratCard extends Card {
    private Rank rank;
    private Suit suit;

    // TODO: Create a stub for the constructor
    public BaccaratCard(Rank r, Suit s) {
        super(r, s);
        this.rank = r;
        this.suit = s;
    }

    // Create a getter for rank
    public Rank getRank () {
        return rank;
    }

    public Suit getSuit () {
        return suit;
    }

    @Override
    public String toString() {
        char rankSymbol = getRank().getSymbol();
        char suitSymbol = getSuit().getSymbol();
        return String.format("%c%c", rankSymbol, suitSymbol);
    }
     
    

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
    
        
        Card otherCard = (Card) obj;
        
        
        if (this.rank == otherCard.rank && this.suit == otherCard.getSuit()) {
            return true;
        }
        
        return false;

    }

    // compareTo method
    public int compareTo(BaccaratCard otherCard) {
        int difference = suit.compareTo(otherCard.suit);

        if (difference == 0) {
          difference = rank.compareTo(otherCard.rank);
        }
    
        return difference;
    }


    public int value() {
    
        if (rank == Rank.TEN || rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
            return 0;
        }
        
        else {
            return rank.ordinal() + 1;
        }
    }


}


