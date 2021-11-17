package com.techbow.homework.y2021.m11.QiyueWang;

public class QuickSelectFindKthElement {
    //quick select
    public static int findKth(int[] arr, int k){
        return kth(arr, k, 0, arr.length - 1);
    }
    private static int kth(int[] arr, int k, int start, int end){
        int pivot = arr[start];
        int l = start;
        int r = end;
        while (l < r){
            while (l < r && arr[r] > pivot){// has to be r first to fix r
                r--;
            }
            while(l < r && arr[l] <= pivot){
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, start, r);// put the pivot to its position
        //.out.println(Arrays.toString(arr)+" l: "+l+" r: "+r);
        if(r + 1 == k){
            return pivot;
        }else if(r + 1 < k){
            return kth(arr, k, r + 1, end);
        }else{
            return kth(arr, k, start, r - 1);
        }
    }
    private static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = new int[] { 10, 4, 5, 8, 6, 26, 11 };
        System.out.println(findKth(array1, 4));//8
        int[] array2 = new int[] { 10, 4, 5, 8, 6, 11, 26 };
        System.out.println(findKth(array2, 2));//5
        int[] array3 = new int[] { 10, 4, 5, 8, 6, 11, 26 };
        System.out.println(findKth(array3, 1));//4
    }
}
