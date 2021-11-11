package com.techbow.homework.y2021.m11.mengyu.MultithreadingConcurrency;

public class ThreadExample {
    public static void main(String[] args) {
        Runnable lol = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                System.out.println("2");
            }
        };
        Thread thread = new Thread(lol);
        thread.start();
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //do something
        }

        public static void main(String[] args) {
            //do something
        }
    };
    Thread thread = new Thread(runnable);
}
