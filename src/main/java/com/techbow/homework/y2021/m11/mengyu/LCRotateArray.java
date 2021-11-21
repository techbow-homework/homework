package com.techbow.homework.y2021.m11.mengyu;

public class LCRotateArray {
    // 1 2 3 4 5 6 , k = 3
    // 4 5 6 1 2 3
    public void rotateS1(int[] nums, int k) {
    int temp;
        while (k > 0) {
        int last = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            nums[i] = last;
            last = temp;
        }
        k--;
    }
}
    public void rotateS2(int[] nums, int k) {
        flip(nums, 0, nums.length - 1);
        flip(nums, 0, k - 1);
        flip(nums, k, nums.length - 1);
    }
    private void flip(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        LC186RotateArray test = new LC186RotateArray();
        int[] nums = {1,2,3,4,5,6,7,8};
        test.rotateS1(nums, 3);
        //System.out.println(Arrays.toString(nums));
        String A = "abcde";
        System.out.println(A + A);
    }
}
