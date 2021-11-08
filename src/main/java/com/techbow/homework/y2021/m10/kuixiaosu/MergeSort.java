package com.techbow.homework.y2021.m10.kuixiaosu;

public class MergeSort {
    private int ArrayList<Integer> divideAndMerger(ArrayList<Integer> array, int left, int right) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (left == right) {
            result.add(array.get(left));
            return result;
        }
        int mid = left +(right - left) / 2;
        ArrayList<Integer> leftResult = divideAndMerge(array, left, mid);
        ArrayList<Integer> rightResult = divideAndMerge(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }

    private void ArrayList<Integer> divideAndMerge(int[] nums, int start, int end, int[] helper) {
        if (nums == null || nums.length <= 1) return;
        int n = end - start + 1;
        if (n <= 1) return;	int mid = start + (end - start) / 2;

        divideAndMerge(nums, start, mid);
        divideAndMerge(nums, mid + 1, end);
        merge(nums, start, mid, end, helper);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> leftResult, ArrayList<Integer> rightResult){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int leftIdx = 0;
        int rightIdx = 0;
        while (leftIdx <=  leftResult.getSize() && rightIdx <= rightResult.getSize()) {
            if (leftResult.get[leftIdx] < rightResult.get[rightIdx] {
                result.add(leftResult.get[leftIdx++]);
            } else {
                result.add(rightResult.get[rightIdx++]);
            }
        }
// remaining elements on the left
        while(leftIdx <  leftResult.getSize()) {
            result.add(leftResult.get[leftIdx++]);
        }
// remaining elements on the right
        while(rightIdx < rightResult.getSize()) {
            result.add(rightResult.get[rightIdx++]);
        }
        return res;
    }
}
