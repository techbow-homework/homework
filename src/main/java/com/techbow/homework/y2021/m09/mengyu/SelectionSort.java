package com.techbow.homework.y2021.m09.mengyu;

public class SelectionSort {
    public void selectionSort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++){
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, array);
        }
    }
    private void swap(int current, int minIndex, int[] array) {
        int temp = array[current];
        array[current] = array[minIndex];
        array[minIndex] = array[current];
    }
}
