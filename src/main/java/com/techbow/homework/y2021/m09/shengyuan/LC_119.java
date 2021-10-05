package com.techbow.homework.y2021.m09.shengyuan;

import java.util.ArrayList;
import java.util.List;

public class LC_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        //cc
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i <= rowIndex; i++) {
            //add(int index, E element)
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                //set(int index, E element): replaces the element at the specified position
                //get(int index): returns the element at the specified position
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC_119 test = new LC_119();
        int index = 5;
        List<Integer> result = test.getRow(index);
        System.out.println(result);
    }
}
