package edu.wctc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This is a utility class consisting of static methods to determine the ranking of a 5 card poker hand
 * @author Samuel
 * @version 1.0
 */
public class Game {

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @param numberOfMatchingFaces the number of cards that need to share the same face
     * @return The number of times that a face showed up the same amount of times as numberOfMatches
     */
    private static int getNumberOfFaceMatches(List<Card> hand, int numberOfMatchingFaces) {
        List<Integer> facesCount = countOfEachFaceInHand(hand);
        int countFaceMatches = 0;
        for (Integer faceCount : facesCount) {
            if (faceCount == numberOfMatchingFaces) {
                countFaceMatches++;
            }
        }
        return countFaceMatches;
    }

    /**
     * @param hand a list of cards to search through
     * @return a list of how many times each card face showed up in hand
     */
    private static List<Integer> countOfEachFaceInHand(List<Card> hand) {
        List<Integer> faceFrequencies = new ArrayList<>();
        for (Face face : Face.values()) {
            int numberOfFace = 0;
            for (Card card : hand) {
                numberOfFace += card.getFace() == face ? 1 : 0;
            }
            faceFrequencies.add(numberOfFace);
        }
        return faceFrequencies;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if there is a poker straight, False if not
     */
    private static boolean isStraight(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getFace));
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getFace().ordinal() != hand.get(i+1).getFace().ordinal() - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if there is a poker flush, False if not
     */
    private static boolean isFlush(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getSuit));
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getSuit().ordinal() != hand.get(i+1).getSuit().ordinal()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if there is an ace in the given hand, False if not
     */
    private static boolean hasAceInHand(List<Card> hand) {
        for (Card card : hand) {
            if (card.getFace() == Face.ACE) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains a poker royal flush, False if not
     */
    public static boolean isRoyalFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand) && hasAceInHand(hand);
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains a poker straight flush and not a poker royal flush, False if not
     */
    public static boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand) && !hasAceInHand(hand);
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains four of a kind, False if not
     */
    public static boolean isFourOfAKind(List<Card> hand) {
        return getNumberOfFaceMatches(hand, 4) == 1;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains three of a kind and two of a kind, False if not
     */
    public static boolean isFullHouse(List<Card> hand) {
        return getNumberOfFaceMatches(hand, 3) == 1 && getNumberOfFaceMatches(hand, 2) == 1;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains a poker flush and not a poker straight, False if hand contains no flush, or if hand contains a straight
     */
    public static boolean isFlushNotStraight(List<Card> hand) {
        return isFlush(hand) && !isStraight(hand);
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains a poker straight and not a poker flush, False if hand contains no straight, or if hand contains a flush
     */
    public static boolean isStraightNotFlush(List<Card> hand) {
        return isStraight(hand) && !isFlush(hand);
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains only three of one card face and not a poker full house, False if hand contains a full house or if hand has no three of one card face
     */
    public static boolean isThreeOfAKind(List<Card> hand) {
        return (getNumberOfFaceMatches(hand, 3) == 1) && getNumberOfFaceMatches(hand, 2) == 0;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains two distinct pairs of cards, False if not
     */
    public static boolean isTwoPair(List<Card> hand) {
        return getNumberOfFaceMatches(hand, 2) == 2;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains only one pair of exactly two cards in hand, False if more than one pair or no pairs
     */
    public static boolean isTwoOfAKind(List<Card> hand) {
        return getNumberOfFaceMatches(hand, 2) == 1 && getNumberOfFaceMatches(hand, 3) == 0;
    }

    /**
     * @param hand a list of cards that make up the poker hand to rank
     * @return True if hand contains no ranked poker hand and only a high card, False if any ranked hand can be made
     */
    public static boolean isHighCard(List<Card> hand) {
        return !isTwoOfAKind(hand) && !isTwoPair(hand) && !isThreeOfAKind(hand) && !isStraight(hand) && !isFlush(hand) && !isFullHouse(hand) && !isFourOfAKind(hand);
    }
}
