package com.techbow.homework.y2021.m10.kuixiaosu;

public class ArrayStack<T> {
    //field
    private T[] array;
    private int head;

    //method
    public MyStack(int capacity){
        array = new T[capacity];
        head = 0;
    }

    public boolean offer(T val){
        if (head >= array.length) return false;
        array[head++] = val;
        return true;
    }
    public T peek(){
        return (head == 0)? null : array[head - 1];
    }
    public T pool(){
        if (head == 0) return null;
        return array[--head];
    }
}
