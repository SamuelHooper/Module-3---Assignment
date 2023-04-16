package edu.wctc;

/**
 * This is a class to store the data for a single standard playing card
 * @author Samuel
 * @version 1.0
 */
public class Card {
    private final Face face;
    private final Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }
}
