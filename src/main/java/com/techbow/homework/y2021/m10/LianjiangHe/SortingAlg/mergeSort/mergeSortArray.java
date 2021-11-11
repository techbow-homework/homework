package com.howdio.chap3;

public class mergeSortArray {
    public static class ArrayUtils {
        public static void printArray(int[] array) {
            System.out.print("{");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }
    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

        System.out.println("Before sort:");
        ArrayUtils.printArray(array);

        mergeSort(array);

        System.out.println("After sort:");
        ArrayUtils.printArray(array);
    }
    public static int[] mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1, helper);
        return array;
    }

    private static void mergeSort(int[] array, int left, int right, int[] helper) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid, helper);
        mergeSort(array, mid + 1, right, helper);
        merge(array, left, right, mid, helper);
    }

    private static void merge(int[] array, int left, int right, int mid, int[] helper) {
        int leftStart = left;
        int rightStart = mid + 1;
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        while (leftStart <= mid && rightStart <= right) {
            if (helper[leftStart] <= helper[rightStart]) {
                array[left++] = helper[leftStart++];
            } else {
                array[left++] = helper[rightStart++];
            }
        }
        while (leftStart <= mid) {
            array[left++] = helper[leftStart++];
        }
    }
}