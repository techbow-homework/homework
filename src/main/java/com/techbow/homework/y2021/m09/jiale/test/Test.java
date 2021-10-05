package com.techbow.homework.y2021.m09.jiale.test;

public class Test {
    public void fun(int n) {
        if (n < 2) {
            return;
        }
        System.out.println(n);
        fun(n/2);
        fun(n/2);
        System.out.println(1);
    }

    public static void main(String[] args) {
        new Test().fun(5);
    }
}
