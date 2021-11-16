package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;

public class LC380InsetDeleteGetRandomO1 {
    private Map<Integer, Integer> m;
    private List<Integer> list;
    private Random rand;
    public LC380InsetDeleteGetRandomO1() {
        m = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(m.containsKey(val)) return false;
        m.put(val, list.size()); // val and index pair
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(m.size() == 0 || !m.containsKey(val)) return false;
        int index = m.get(val); // get the index of the number to be removed
        int lastNum = list.get(list.size() - 1); // store the last number int the list
        list.set(index, lastNum); // swap it to the removed index
        m.put(lastNum, index); // update the map
        list.remove(list.size() - 1); // remove the last element cost O(1)
        m.remove(val); // remove the mapping of val
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        LC380InsetDeleteGetRandomO1 obj = new LC380InsetDeleteGetRandomO1();
        System.out.println(obj.insert(1));//true
        System.out.println(obj.remove(2));//false
        System.out.println(obj.insert(2));//true
        System.out.println(obj.getRandom());// 1 or 2
        System.out.println(obj.remove(1));//true
        System.out.println(obj.insert(2));//false
        System.out.println(obj.getRandom());//2
    }
}
