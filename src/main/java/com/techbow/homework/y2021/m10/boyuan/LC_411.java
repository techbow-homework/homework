package com.techbow.homework.y2021.m10.boyuan;

public class LC_411  {
    public static void main(String[] args) {
        LC_411 binary = new LC_411();
        int[] arr = new int[] {1,2,3,4,5};
        int target = 3;
        int res = binary.findTarget(arr, target);
        System.out.println(res);
    }
    public int findTarget (int[] arr, int target) {
        if (arr == null || arr.length == 0) {
             return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left +  (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}
