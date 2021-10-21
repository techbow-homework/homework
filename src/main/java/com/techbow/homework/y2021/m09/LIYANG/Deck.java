package com.techbow.homework.y2021.m09.LIYANG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
    //fields
    private List<Card> cards;
    //methods
    public Deck(){
        cards = new ArrayList<>();
        for(Suit temp : Suit.values()){
            for(int i = 1; i <= 13; i++){
                cards.add(new Card(i, temp));
            }
        }
    }

    public Card deal(){//发一张牌
        return cards.remove(cards.size() - 1);
    }

    public List<Card> deal(int n){ // 指定发牌数量
        if(n < 0) return null;
        List<Card> res = new LinkedList<>();
        for(int i = 0; i< n; i++){
            res.add(deal());
        }
        return res;
    }

    public void shuffle(){
        Random random = new Random(); //TODO singleton
        int size = cards.size();
        for(int i = 0; i < size - 1; i++){
            int index = random.nextInt(size - i);
            swap(cards,index, size - i); //和最后一个swap
        }
    }

    private void swap(List<Card> cards, int index1, int index2){

    }

}
