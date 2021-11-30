package com.techbow.homework.y2021.m10.yeboyr;

import java.util.ArrayList;

public class Array {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers.get(0));

        for (int i = 0;i< numbers.size();i++){
            System.out.println(numbers.get(i));
        }
    }
}
