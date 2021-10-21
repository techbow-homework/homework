package com.techbow.homework.y2021.m10.LianjiangHe.JAVABasics;

/*
Collection(存储单个值)
    List 可重复,有序
        ArrayList
        LinkedList
        Vector
    Set 不可重复,无序
        HashSet
        TreeSet

Map(用来存储Key-Value)
    HashMap
    TreeMap
    HashTable
    */

import java.util.ArrayList;
import java.util.HashSet;

//Q:去除ArrayList集合中的重复元素(使用2种方法)
public class Practice_20211018 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("a");
        al.add("b");
        al.add("c");
        al.add("a");

        //option 1
    /*    ArrayList<String> nl = new ArrayList<String>();
        for (String s: al
        ) {
            if (nl.contains(s)==false){
                nl.add(s);
            }
        }
        for (String s:nl
        ) {
            System.out.print(s+" ");
        }*/

        //option 2
        HashSet<String> set = new HashSet<String>();
        for (String s: al
        ) {
            set.add(s);
        }
        for (String s: set
        ) {
            System.out.print(s+" ");

        }
    }
}
