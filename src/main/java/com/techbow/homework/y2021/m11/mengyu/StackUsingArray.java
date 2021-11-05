package com.techbow.homework.y2021.m11.mengyu;

public class StackUsingArray {
    //field
    private int[] array;
    private int head;
    private static final int DEFAULT_CAPACITY = 10;
    //method
    //constructor
    public StackUsingArray (int capacity) {
        array = new int[capacity];
        head = 0;
    }
    public StackUsingArray () {
        this(DEFAULT_CAPACITY);
    }
    //push
    public boolean push (int val) {//TODO: Expand
        if (head >= array.length) return false;
        array[head++] = val;
        return true;
    }
    //pop
    public Integer pop() {
        if (head == 0) return null;
        return array[--head];
    }
    //peek
    public Integer peek() {
        return head == 0 ? null : array[head - 1];
    }

}
