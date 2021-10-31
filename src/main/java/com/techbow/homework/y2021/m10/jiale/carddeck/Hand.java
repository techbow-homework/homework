package com.techbow.homework.y2021.m10.jiale.carddeck;

import java.util.ArrayList;
import java.util.List;

public class Hand <T extends Card>{
    protected List<T> cards = new ArrayList<>();

    public void addCard(T card) {
        cards.add(card);
    }
}
