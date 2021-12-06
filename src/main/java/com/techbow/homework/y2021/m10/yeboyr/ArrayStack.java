package com.techbow.homework.y2021.m10.yeboyr;

public class ArrayStack {
    private int[] array;
    private int head;
    static final int DEFAUL_CAPACITY = 10;

    public ArrayStack(int capacity){
        int[] array = new int[capacity];
        head = 0;
    }
    public ArrayStack() {
        int[] array = new int[DEFAUL_CAPACITY];
        head = 0;
    }

    public boolean offer(int item){
        if(head>=array.length){
            return false;
        } else {
            array[head++] = item;
            head++;
        }
        return true;
    }

    public int peek(){
        return (head==0)?null:array[head-1];
    }


}
