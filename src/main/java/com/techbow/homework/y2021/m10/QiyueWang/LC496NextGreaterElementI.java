package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.*;

public class LC496NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(nums2[0]);
        int[] res = new int[m];
        Arrays.fill(res, -1);
        for(int i = 0; i < m; i ++){
            map.put(nums1[i], i);
        }

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && stack.peekLast() < nums2[i]){
                int out = stack.pollLast();
                int index = map.getOrDefault(out, -1);
                if(index > -1){
                    res[index] = nums2[i];// set the next greater
                }
            }
            stack.offerLast(nums2[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2))); // [-1,3,-1]
    }
}
// time O(N+M) space O(N)
