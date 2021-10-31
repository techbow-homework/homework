package com.techbow.homework.y2021.m10.jiale.carddeck;

public class BlackJackCard extends Card{
    public BlackJackCard (int c, Suit s) {
        super(c, s);
    }

    @Override
    public int getFaceValue() {
        return 0;
    }


}
