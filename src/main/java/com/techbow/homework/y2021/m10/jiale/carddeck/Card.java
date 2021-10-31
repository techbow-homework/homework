package com.techbow.homework.y2021.m10.jiale.carddeck;

public abstract class Card {
    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public Suit getSuit() {
        return suit;
    }

    public abstract int getFaceValue();
}
