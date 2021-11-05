package com.techbow.homework.y2021.m10.kuixiaosu;

public class SelectionSort {
    public int[]/void selectSort(int[] array) {  //可以用void，因为java是pass by value copy， sort好的array’和array其实是同一个stack heap结构的heap里面是同一个array
        // corner case
        if (array == null || array.length <= 1) return array;
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) { //不需要走完
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                swap(array, i, minIndex);
            }
            return array;
        }

        private void swap ( int[] array, int i, int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
