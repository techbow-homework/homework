package com.techbow.homework.y2021.m10.kuixiaosu;

public class Deck {
    //fields
    private ArrayList<Card> cards;

    Singleton;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i, suit));
            }
        }

    private final int value;
    private final Suit suit;

    public Card(int val, Suit suit) {
        value = val;
        this.suit = suit;
    }

    public int getCardVal() {
        return value;
    }

    public Suit getCardSuit() {
        return suit;
    }
}
