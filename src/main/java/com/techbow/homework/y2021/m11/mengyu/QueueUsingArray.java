package com.techbow.homework.y2021.m11.mengyu;

public class QueueUsingArray {
    //field
    private int[] array;
    private int head, tail;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    //method
    //constructor
    public QueueUsingArray(int capacity) {
        array = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }
    public QueueUsingArray() {
        this(DEFAULT_CAPACITY);
    }
    //offer
    public boolean offer(int val) { //TODO: Expand
        if (size == array.length) {
            return false;
        } else {
            array[tail] = val;
            tail = (tail + 1) % array.length;
            size++;
        }
        return true;
    }
    //poll
    public Integer poll() {
        if (size == 0) return null;
        int res = array[head];
        head = (head + 1) % array.length;
        size--;
        return res;
    }
    //peek
    public Integer peek() {
        return size == 0 ? null : array[head];
    }
}
