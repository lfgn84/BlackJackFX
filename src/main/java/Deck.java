
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {

    public List<Card> deckOfCards = new ArrayList<>();

    public Deck() {
        newDeck();
    }

    public void shuffleDeck(List<Card> lista) {
        Collections.shuffle(lista);
    }

    public Card drawCard(){
        Card card = deckOfCards.get(0);
        deckOfCards.remove(0);
        return card;
    }

    public void newDeck() {
        for (int i = 0; i < Rank.ranks.size(); i++) {
            Card card = new Card(Suits.suits.HEARTS, Rank.ranks.get(i), new Image(Card.getFilename(Rank.ranks.get(i),Suits.suits.HEARTS)));
            deckOfCards.add(card);
        }
        for (int i = 0; i < Rank.ranks.size(); i++) {
            Card card = new Card(Suits.suits.DIAMONDS, Rank.ranks.get(i), new Image(Card.getFilename(Rank.ranks.get(i),Suits.suits.DIAMONDS)));
            deckOfCards.add(card);
        }
        for (int i = 0; i < Rank.ranks.size(); i++) {
            Card card = new Card(Suits.suits.SPADES, Rank.ranks.get(i), new Image(Card.getFilename(Rank.ranks.get(i),Suits.suits.SPADES)));
            deckOfCards.add(card);
        }
        for (int i = 0; i < Rank.ranks.size(); i++) {
            Card card = new Card(Suits.suits.CLUBS, Rank.ranks.get(i), new Image(Card.getFilename(Rank.ranks.get(i),Suits.suits.CLUBS)));
            deckOfCards.add(card);
        }
        shuffleDeck(deckOfCards);
    }
}
