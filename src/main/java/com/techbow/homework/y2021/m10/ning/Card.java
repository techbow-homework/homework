package com.techbow.homework.y2021.m10.ning;

public class Card {
    private final int value;
    private final Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    public int getCardValue() {
        return value;
    }
    public Suit getCardSuit() {
        return suit;
    }
}
