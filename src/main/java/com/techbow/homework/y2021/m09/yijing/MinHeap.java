package com.techbow.homework.y2021.m09.yijing;

import java.util.Arrays;

public class MinHeap{
    //field
    private int [] array;
    private int size;

    //methods
    public MinHeap(int cap){
        if (cap <= 0) throw new IllegalArgumentException("Capacity cant be smaller 0");
        else{
            array = new int[cap];
            size = 0;
        }
    }

    public MinHeap(){}

    public MinHeap(int[] array){
        size = array.length;
        this.array = Arrays.copyOf(array, array.length * 2);
        heapify();
    }

    public void offer(int val){
        if ( size == array.length){
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = val;
        percolateup(size);
        size++;
    }

    public Integer poll(){
        if (size == 0) return null;
        int item = array[0];
        array[0] = array[size - 1];
        percolatedown(array[0]);
        size--;
        return item;
    }

    public int update(int index, int val) throws Exception {
        if(index <0 || index > size) throw new Exception();
        int temp = array[index];
        array[index] = val;
        if(temp < val) percolatedown(index);
        else percolateup(index);
        return temp;
    }

    public int peek(){
        return array[0];
    }

    private void heapify(){
        for (int i = (size - 2) / 2; i >= 0; i--) percolatedown(i);
    }

    private void percolateup(int index) {
        while (index > 0) {
            if (array[(index - 1) / 2] > array[index]) swap(array, (index - 1) / 2, index);
            else break;
            index = (index - 1) / 2;
        }
    }

    private void percolatedown(int index){
        while(index >= 0 && index <= (size - 2) / 2 ){
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int swapIndex = left;
            if (right < size) {
                if (array[right] < array[left]) {
                    swapIndex = right;
                }
            }
            if (array[index] > array[swapIndex]) {
                swap(array, index, swapIndex);
            } else break;
            index = swapIndex;
        }
    }

    private void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

class test{
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 8, 9, 4, 66, 0};
        MinHeap test1 = new MinHeap(a);
        System.out.println(test1.peek());
    }
}