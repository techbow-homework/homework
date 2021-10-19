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
    }
}