// TODO: Implement the BaccaratHand class in the file
import java.util.List;
import java.util.ArrayList;


public class BaccaratHand extends CardCollection {
    private List<BaccaratCard> cards;

    // Constructor
    public BaccaratHand() {
        cards = new ArrayList<>();
    }

    // Method to add a card to the hand
    public void add(BaccaratCard card) {
        cards.add(card);
    }

    // Method to get the size of the hand
    public int size() {
        return cards.size();
    }

    // Method to generate a string representation of the hand
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (BaccaratCard c : cards) {
            char rankSymbol = c.getRank().getSymbol();
            char suitSymbol = c.getSuit().getSymbol();
            result.append(String.format("%c%c ", rankSymbol, suitSymbol));
        }

        return result.toString().trim();
    }

    // Method to calculate the value of the hand in Baccarat
    public int value() {
        int totalValue = 0; 
        for (BaccaratCard c : cards) {
            totalValue += c.value();
            
        }
        return totalValue % 10;
    }

    // Method to check if the hand is a natural
    public boolean isNatural() {
        int totalValue = value();
        if (cards.size() == 2 && (totalValue == 8 || totalValue ==9 )) {
            return true;
        } else {
            return false;
        }
        
    }
}