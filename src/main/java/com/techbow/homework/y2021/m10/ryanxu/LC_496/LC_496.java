package com.techbow.homework.y2021.m10.ryanxu.LC_496;

import java.util.HashMap;
import java.util.Stack;

public class LC_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else if (stack.peek() >= num) {
                stack.push(num);
            } else {
                while (!stack.isEmpty() && stack.peek() < num) {
                    nextGreater.put(stack.pop(), num);
                }
                stack.push(num);
            }
        }

        int len1 = nums1.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
