package com.techbow.homework.y2021.m10.yijing;
// JavaOOD7 Design a generic deck of cards

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{
    private final int num;
    private final Suit suit;

    public Card(int num, Suit suit){
        this.num = num;
        this.suit = suit;
    }

    public int getnum(){
        return num;
    }

    public Suit getsuit(){
        return suit;
    }
}

enum Suit {
    CLUB,
    DIAMOND,
    HEART,
    SPADE
}


public class Deck{
    List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        for(Suit suit:Suit.values()){
            for(int i = 1; i < 14; i++){
                cards.add(new Card(i, suit));
            }
        }
    }

    public void shuffle(){
        Random random = new Random();
        for (int i = 0; i < random.nextDouble() * cards.size(); i++) {
            int j = random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public Card deal(){
        return  cards.remove(cards.size() - 1);
    }

    public List<Card> deal(int num){
        List<Card> d = new ArrayList<>();
        for(int i = 0; i < num; i++){
            d.add(deal());
        }
        return d;
    }
}


