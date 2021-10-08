package com.techbow.homework.y2021.m09.mengyu;

public class InsertionSort {
    public void insertionSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int position = index - 1;
            int temp = arr[index];
            while (position >= 0 && arr[position] > arr[index]) {
                arr[position + 1] = arr[position];
                position -= 1;
            }
            arr[position + 1] = temp;
        }
    }
}
