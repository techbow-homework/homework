package com.techbow.homework.y2021.m10.mingyu;

public class LC33 {
    int [] nums;
    int target;
    public int FindRotateIndex(int left, int right){
        if (nums[left] < nums[right])
            return 0;
        while (left <= right){
            int pivot = (left +right) / 2;
            if (nums[pivot] > nums[pivot + 1]])
                return pivot +1;
            else{
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

public int search (int left, int right) {
    /*
    Binary Search
     */
    while (left <= right) {
        int pivot = (left + right) / 2;
        if (nums[pivot] == target)
            return pivot;
        else {
            if (target < nums[pivot])
                right = pivot - 1;
            else
                left = pivot + 1;
        }
    }
    return -1;
    }
    public int search(int [] nums, int target){
    this.nums = nums;
    this.target = target;

    int n = nums.length;

    if (n == 1)
        return this.nums[0] == target ? 0 : -1;
    int RotateIndex = FindRotateIndex(0,n - 1);
    if (nums[RotateIndex] ==target)
        return RotateIndex;
    if (RotateIndex = 0)
        return search(0, n - 1);
    if (target < nums[0])
        return search(RotateIndex, n-1);
    return search(0, RotateIndex);
    }
}
