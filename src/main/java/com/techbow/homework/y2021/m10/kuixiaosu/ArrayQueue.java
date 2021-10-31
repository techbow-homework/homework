package com.techbow.homework.y2021.m10.kuixiaosu;

public class ArrayQueue {
    //fields
    private int[] array;
    private int head;
    private int tail;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue(int cap) {
        array = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }
    public ArrayQueue() {
        this (DEFAULT_CAPACITY);
    }
    public boolean offer(){
        if (size == array.length) return false;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }
    public int poll(){
        if (size == 0) return null;
        int res = array[head];
        head = (head + 1) % array.length;
        size--;
        return res;
    }

    public int peek(){
        return size == 0 ? null : array[head];
    }
}
