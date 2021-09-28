package com.techbow.homework.y2021.m09.jiale.leetcode;

public class LC_75 {
    /**
     * sort colors
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * You must solve this problem without using the library's sort function.
     * <p>
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * <p>
     * analysis: I plan to use three pointer to divide the input array into 4 parts.
     * three pointers pLeft, pMid, pRight
     * pLeft, pMid start from 0, pRight start from input.length-1
     * <p>
     * [0, pLeft) -> 0
     * [pLeft, pMid) -> 1
     * [pMid, pRight) -> to be scanned
     * [pRight, length-1] -> 2
     * <p>
     * our loop end when pMid >= pRight
     * when
     * arr[pMid] == 0 -> swap pMid and pLeft, pLeft++ pMid++
     * arr[pMid] == 1 -> pMid++
     * arr[pMid] == 2 -> swap pMid and pRight, pRight--, do not move pMid, we need to check arr[RLight]
     * demo:
     * 2, 0, 2, 1, 1, 0
     * 2, 0, 2, 1, 1, 0
     * l  r
     * m
     * 0  0  1  1  2  2
     * Time Complexity: O(n) just one scan
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        if (nums.length < 1) {
            return;
        }

        int pLeft = 0, pMid = 0, pRight = nums.length - 1;
        while (pMid <= pRight) {
            if (nums[pMid] == 0) {
                swap(nums, pMid++, pLeft++);
            } else if (nums[pMid] == 1) {
                pMid++;
            } else {
                swap(nums, pMid, pRight--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {2, 0, 2, 1, 1, 0};
        new LC_75().sortColors(input);
        for (int each : input) {
            System.out.print(each + " ");
        }
    }
}
