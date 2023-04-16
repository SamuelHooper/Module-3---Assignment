package edu.wctc.tests;

import edu.wctc.Card;
import edu.wctc.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.wctc.Face.*;
import static edu.wctc.Suit.*;
import static org.junit.Assert.*;

public class GameTests {
    private final List<Card> royalFlushHand = new ArrayList<>();
    private final List<Card> straightFlushHand = new ArrayList<>();
    private final List<Card> fourOfAKindHand = new ArrayList<>();
    private final List<Card> fullHouseHand = new ArrayList<>();
    private final List<Card> flushHand = new ArrayList<>();
    private final List<Card> straightHand = new ArrayList<>();
    private final List<Card> threeOfAKindHand = new ArrayList<>();
    private final List<Card> twoPairHand = new ArrayList<>();
    private final List<Card> onePairHand = new ArrayList<>();
    private final List<Card> highCardHand = new ArrayList<>();

    @Before
    public void setUp() {
        royalFlushHand.add(new Card(ACE, SPADES));
            royalFlushHand.add(new Card(KING, SPADES));
            royalFlushHand.add(new Card(QUEEN, SPADES));
            royalFlushHand.add(new Card(JACK, SPADES));
            royalFlushHand.add(new Card(TEN, SPADES));
        straightFlushHand.add(new Card(NINE, DIAMONDS));
            straightFlushHand.add(new Card(EIGHT, DIAMONDS));
            straightFlushHand.add(new Card(SEVEN, DIAMONDS));
            straightFlushHand.add(new Card(SIX, DIAMONDS));
            straightFlushHand.add(new Card(FIVE, DIAMONDS));
        fourOfAKindHand.add(new Card(THREE, DIAMONDS));
            fourOfAKindHand.add(new Card(THREE, SPADES));
            fourOfAKindHand.add(new Card(EIGHT, CLUBS));
            fourOfAKindHand.add(new Card(THREE, HEARTS));
            fourOfAKindHand.add(new Card(THREE, CLUBS));
        fullHouseHand.add(new Card(FOUR, CLUBS));
            fullHouseHand.add(new Card(TEN, HEARTS));
            fullHouseHand.add(new Card(TEN, DIAMONDS));
            fullHouseHand.add(new Card(TEN, CLUBS));
            fullHouseHand.add(new Card(FOUR, SPADES));
        flushHand.add(new Card(SIX, HEARTS));
            flushHand.add(new Card(JACK, HEARTS));
            flushHand.add(new Card(TWO, HEARTS));
            flushHand.add(new Card(KING, HEARTS));
            flushHand.add(new Card(EIGHT, HEARTS));
        straightHand.add(new Card(JACK, DIAMONDS));
            straightHand.add(new Card(TEN, DIAMONDS));
            straightHand.add(new Card(NINE, CLUBS));
            straightHand.add(new Card(EIGHT, HEARTS));
            straightHand.add(new Card(SEVEN, CLUBS));
        threeOfAKindHand.add(new Card(KING, DIAMONDS));
            threeOfAKindHand.add(new Card(TEN, DIAMONDS));
            threeOfAKindHand.add(new Card(TEN, HEARTS));
            threeOfAKindHand.add(new Card(FOUR, SPADES));
            threeOfAKindHand.add(new Card(TEN, CLUBS));
        twoPairHand.add(new Card(KING, DIAMONDS));
            twoPairHand.add(new Card(TWO, SPADES));
            twoPairHand.add(new Card(FOUR, CLUBS));
            twoPairHand.add(new Card(TWO, CLUBS));
            twoPairHand.add(new Card(KING, HEARTS));
        onePairHand.add(new Card(FIVE, CLUBS));
            onePairHand.add(new Card(QUEEN, HEARTS));
            onePairHand.add(new Card(FIVE, HEARTS));
            onePairHand.add(new Card(FOUR, SPADES));
            onePairHand.add(new Card(JACK, CLUBS));
        highCardHand.add(new Card(QUEEN, DIAMONDS));
            highCardHand.add(new Card(NINE, CLUBS));
            highCardHand.add(new Card(JACK, HEARTS));
            highCardHand.add(new Card(TEN, SPADES));
            highCardHand.add(new Card(FIVE, SPADES));
    }

    @Test
    public void royalFlushTests() {
        assertTrue(Game.isRoyalFlush(royalFlushHand));
        assertFalse(Game.isRoyalFlush(straightFlushHand));
        assertFalse(Game.isRoyalFlush(fourOfAKindHand));
        assertFalse(Game.isRoyalFlush(fullHouseHand));
        assertFalse(Game.isRoyalFlush(flushHand));
        assertFalse(Game.isRoyalFlush(straightHand));
        assertFalse(Game.isRoyalFlush(threeOfAKindHand));
        assertFalse(Game.isRoyalFlush(twoPairHand));
        assertFalse(Game.isRoyalFlush(onePairHand));
        assertFalse(Game.isRoyalFlush(highCardHand));
    }

    @Test
    public void straightFlushTests() {
        assertFalse(Game.isStraightFlush(royalFlushHand));
        assertTrue(Game.isStraightFlush(straightFlushHand));
        assertFalse(Game.isStraightFlush(fourOfAKindHand));
        assertFalse(Game.isStraightFlush(fullHouseHand));
        assertFalse(Game.isStraightFlush(flushHand));
        assertFalse(Game.isStraightFlush(straightHand));
        assertFalse(Game.isStraightFlush(threeOfAKindHand));
        assertFalse(Game.isStraightFlush(twoPairHand));
        assertFalse(Game.isStraightFlush(onePairHand));
        assertFalse(Game.isStraightFlush(highCardHand));
    }

    @Test
    public void fourOfAKindTests() {
        assertFalse(Game.isFourOfAKind(royalFlushHand));
        assertFalse(Game.isFourOfAKind(straightFlushHand));
        assertTrue(Game.isFourOfAKind(fourOfAKindHand));
        assertFalse(Game.isFourOfAKind(fullHouseHand));
        assertFalse(Game.isFourOfAKind(flushHand));
        assertFalse(Game.isFourOfAKind(straightHand));
        assertFalse(Game.isFourOfAKind(threeOfAKindHand));
        assertFalse(Game.isFourOfAKind(twoPairHand));
        assertFalse(Game.isFourOfAKind(onePairHand));
        assertFalse(Game.isFourOfAKind(highCardHand));
    }

    @Test
    public void fullHouseTests() {
        assertFalse(Game.isFullHouse(royalFlushHand));
        assertFalse(Game.isFullHouse(straightFlushHand));
        assertFalse(Game.isFullHouse(fourOfAKindHand));
        assertTrue(Game.isFullHouse(fullHouseHand));
        assertFalse(Game.isFullHouse(flushHand));
        assertFalse(Game.isFullHouse(straightHand));
        assertFalse(Game.isFullHouse(threeOfAKindHand));
        assertFalse(Game.isFullHouse(twoPairHand));
        assertFalse(Game.isFullHouse(onePairHand));
        assertFalse(Game.isFullHouse(highCardHand));
    }

    @Test
    public void flushTests() {
        assertFalse(Game.isFlushNotStraight(royalFlushHand));
        assertFalse(Game.isFlushNotStraight(straightFlushHand));
        assertFalse(Game.isFlushNotStraight(fourOfAKindHand));
        assertFalse(Game.isFlushNotStraight(fullHouseHand));
        assertTrue(Game.isFlushNotStraight(flushHand));
        assertFalse(Game.isFlushNotStraight(straightHand));
        assertFalse(Game.isFlushNotStraight(threeOfAKindHand));
        assertFalse(Game.isFlushNotStraight(twoPairHand));
        assertFalse(Game.isFlushNotStraight(onePairHand));
        assertFalse(Game.isFlushNotStraight(highCardHand));
    }

    @Test
    public void straightTests() {
        assertFalse(Game.isStraightNotFlush(royalFlushHand));
        assertFalse(Game.isStraightNotFlush(straightFlushHand));
        assertFalse(Game.isStraightNotFlush(fourOfAKindHand));
        assertFalse(Game.isStraightNotFlush(fullHouseHand));
        assertFalse(Game.isStraightNotFlush(flushHand));
        assertTrue(Game.isStraightNotFlush(straightHand));
        assertFalse(Game.isStraightNotFlush(threeOfAKindHand));
        assertFalse(Game.isStraightNotFlush(twoPairHand));
        assertFalse(Game.isStraightNotFlush(onePairHand));
        assertFalse(Game.isStraightNotFlush(highCardHand));
    }

    @Test
    public void threeOfAKindTests() {
        assertFalse(Game.isThreeOfAKind(royalFlushHand));
        assertFalse(Game.isThreeOfAKind(straightFlushHand));
        assertFalse(Game.isThreeOfAKind(fourOfAKindHand));
        assertFalse(Game.isThreeOfAKind(fullHouseHand));
        assertFalse(Game.isThreeOfAKind(flushHand));
        assertFalse(Game.isThreeOfAKind(straightHand));
        assertTrue(Game.isThreeOfAKind(threeOfAKindHand));
        assertFalse(Game.isThreeOfAKind(twoPairHand));
        assertFalse(Game.isThreeOfAKind(onePairHand));
        assertFalse(Game.isThreeOfAKind(highCardHand));
    }

    @Test
    public void twoPairTests() {
        assertFalse(Game.isTwoPair(royalFlushHand));
        assertFalse(Game.isTwoPair(straightFlushHand));
        assertFalse(Game.isTwoPair(fourOfAKindHand));
        assertFalse(Game.isTwoPair(fullHouseHand));
        assertFalse(Game.isTwoPair(flushHand));
        assertFalse(Game.isTwoPair(straightHand));
        assertFalse(Game.isTwoPair(threeOfAKindHand));
        assertTrue(Game.isTwoPair(twoPairHand));
        assertFalse(Game.isTwoPair(onePairHand));
        assertFalse(Game.isTwoPair(highCardHand));
    }

    @Test
    public void twoOfAKindTests() {
        assertFalse(Game.isTwoOfAKind(royalFlushHand));
        assertFalse(Game.isTwoOfAKind(straightFlushHand));
        assertFalse(Game.isTwoOfAKind(fourOfAKindHand));
        assertFalse(Game.isTwoOfAKind(fullHouseHand));
        assertFalse(Game.isTwoOfAKind(flushHand));
        assertFalse(Game.isTwoOfAKind(straightHand));
        assertFalse(Game.isTwoOfAKind(threeOfAKindHand));
        assertFalse(Game.isTwoOfAKind(twoPairHand));
        assertTrue(Game.isTwoOfAKind(onePairHand));
        assertFalse(Game.isTwoOfAKind(highCardHand));
    }

    @Test
    public void highCardTests() {
        assertFalse(Game.isHighCard(royalFlushHand));
        assertFalse(Game.isHighCard(straightFlushHand));
        assertFalse(Game.isHighCard(fourOfAKindHand));
        assertFalse(Game.isHighCard(fullHouseHand));
        assertFalse(Game.isHighCard(flushHand));
        assertFalse(Game.isHighCard(straightHand));
        assertFalse(Game.isHighCard(threeOfAKindHand));
        assertFalse(Game.isHighCard(twoPairHand));
        assertFalse(Game.isHighCard(onePairHand));
        assertTrue(Game.isHighCard(highCardHand));
    }
}
