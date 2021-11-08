package com.techbow.homework.y2021.m10.kuixiaosu;

public class QuickSort {
    public int[] quickSort(int[] array) {
        //corner case
        if (array == null || array.length <= 1) return array;
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        return array;
    }

    private void quickSort(int[] array, int left, int right){
        if (left >= right) return;
        int pivotIdx = findPivotAndPartition(array, left, right);
        quickSort(array, left, pivotIdx - 1);
        quickSort(array, pivotIdx + 1, right);
    }
    private int findPivotAndPartition(int[] array, int left, int right){
        int rightIdx = right;
        int leftIdx = left;
        Random rand = new Random();
        int pivot = left + rand.nextInt(right - left + 1);
        int pivotVal = array[pivot];
        swap(array, pivot, right);
        rightIdx--;
        while (leftIdx <= rightIdx){
            if (array[leftIdx] <= pivotVal) leftIdx ++;
            else if (array[rightIdx] > pivotVal) rightIdx --;
            else swap(array, leftIdx++, rightIdx--);
        }
        swap(array, leftIdx, right);
        return leftIdx;
    }
}
