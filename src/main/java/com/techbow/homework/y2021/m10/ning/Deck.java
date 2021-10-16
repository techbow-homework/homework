//package com.techbow.homework.y2021.m10.ning;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class Deck {
//    private final int id;
//    private List<Card> cards;
//    Random random = new Random();
//
//    public Deck {
//        cards = new ArrayList<Card>();
//        for (Suit suit : Suit.value()) {
//            for (int i = 1; i <= 13; i++) {
//                cards.add(new Card(i, suit));
//            }
//        }
//    }
//    public Card deal() {
//        return cards.remove(cards.size() - 1);
//    }
//    public List<Card> deal(int num) {
//        for (int i = 0; i < num; i++) {
//            deal();
//        }
//    }
//    public void Shuffle() {
//        for (int i = 0; i < cards.size(); i++) {
//            int j = random.nextInt(cards.size() - i) + i;
//            Card card1 = cards.get(i);
//            Card card2 = cards.get(j);
//            cards.set(i, card2);
//            cards.set(j, card1);
//        }
//    }
//}
