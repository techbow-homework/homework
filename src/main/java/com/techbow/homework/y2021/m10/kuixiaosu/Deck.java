package com.techbow.homework.y2021.m10.kuixiaosu;

public class Deck {
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
