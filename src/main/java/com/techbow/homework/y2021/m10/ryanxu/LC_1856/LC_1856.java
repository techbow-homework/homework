package com.techbow.homework.y2021.m10.ryanxu.LC_1856;

import java.util.HashMap;
import java.util.Stack;

public class LC_1856 {

    private static int M = (int) 1e9 + 7;

    public int maxSumMinProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> nextSmaller = getNextSmaller(nums);
        HashMap<Integer, Integer> prevSmaller = getPrevSmaller(nums);
        int len = nums.length;
        long res = Long.MIN_VALUE;
        long[] presum = getPresum(nums);
        for (int i = 0; i < len; i++) {
            int prevIdx = prevSmaller.getOrDefault(i, -1);
            int nextIdx = nextSmaller.getOrDefault(i, len);
            res = Math.max(res, nums[i] * (presum[nextIdx - 1] - (prevIdx == -1 ? 0 : presum[prevIdx])));
        }

        return (int) (res % M);
    }

    private long[] getPresum(int[] nums) {

        int len = nums.length;
        long[] res = new long[len];
        res[0] = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + nums[i];
        }

        return res;
    }

    private HashMap<Integer, Integer> getNextSmaller(int[] nums) {

        HashMap<Integer, Integer> res = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                res.put(stack.pop(), i);
            }
            stack.push(i);
        }
        return res;
    }

    private HashMap<Integer, Integer> getPrevSmaller(int[] nums) {

        HashMap<Integer, Integer> res = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                res.put(stack.pop(), i);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_1856 lc_1856 = new LC_1856();
        int[] nums = {1,2,3,2};
        System.out.println(lc_1856.maxSumMinProduct(nums));
    }
}
