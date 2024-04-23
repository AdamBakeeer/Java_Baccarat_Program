// TODO: Implement the Shoe class in this file
import java.util.List;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Shoe extends CardCollection{
    private List<BaccaratCard> cards;
    private int numberOfDecks;

    // Constructor
    public Shoe(int numberOfDecks) throws CardException {
        if (numberOfDecks != 6 && numberOfDecks != 8) {
            throw new CardException("Number of decks must be either 6 or 8");
        }
        this.numberOfDecks = numberOfDecks;
        cards = new LinkedList<>();
    
        
        for (int i = 0; i < numberOfDecks; i++) {
            for (BaccaratCard.Suit suit : BaccaratCard.Suit.values()) {
                for (BaccaratCard.Rank rank : BaccaratCard.Rank.values()) {
                    BaccaratCard card = new BaccaratCard(rank, suit);
                    cards.add(card);
                }
            }
        }
    }

    // Method to get the size of the shoe
    public int size() {
        return cards.size();
    }

    // Method to shuffle the cards in the shoe
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to deal a card from the shoe
    public BaccaratCard deal() throws CardException {
        if (cards.isEmpty()) {
            throw new CardException("Cannot deal a card from an empty shoe");
        }
        return ((LinkedList<BaccaratCard>) cards).removeFirst();
    }
}