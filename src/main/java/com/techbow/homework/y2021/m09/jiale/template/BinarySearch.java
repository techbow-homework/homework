package com.techbow.homework.y2021.m09.jiale.template;

public class BinarySearch {
    public int binarySearchS1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchS2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid;
            }
            if (nums[mid] > target) {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public int binarySearchS3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    private int binarySearchRecursive(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return binarySearchRecursive(nums, left, mid - 1, target);
        if (nums[mid] < target) return binarySearchRecursive(nums, mid + 1, right, target);
        return -1;
    }
}
