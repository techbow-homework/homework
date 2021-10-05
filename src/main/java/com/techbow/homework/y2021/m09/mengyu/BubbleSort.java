package com.techbow.homework.y2021.m09.mengyu;

public class BubbleSort {
    public static void bubbleSort(int[] nums){
        /*
        2 1 3 4 5 5
            i
            j
         */
        boolean swapped;
        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

    }
    private static void swap(int firstIndex, int secondIndex, int[] arr) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    // Function to print an array
    static void printArray(int arr[])
    {
        int i;
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}

