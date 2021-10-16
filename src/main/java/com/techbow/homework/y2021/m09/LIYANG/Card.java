package com.techbow.homework.y2021.m09.LIYANG;

enum Suit {
    CLUB, //♣️
    DIAMOND, //♦️
    HEART, //♥️
    SPADE; //♠️
}
public class Card {
    //fields
    private int value;
    private Suit suit;
    //methods
    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }
    public int getValue(){
        return this.value;
    }
    public Suit getSuit(){
        return this.suit;
    }
}
