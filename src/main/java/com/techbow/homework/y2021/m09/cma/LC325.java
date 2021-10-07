package com.techbow.homework.y2021.m09.cma;

public class LC325 {
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int maxLen = 0;
            int prefixSum = 0;
            HashMap<Integer, Integer> indices = new HashMap<>();


            for(int i = 0; i < nums.length; i++){
                prefixSum += nums[i];
                if(k == prefixSum){
                    maxLen = i + 1;
                }
                if(indices.containsKey(prefixSum - k)){
                    maxLen = Math.max(maxLen, i - indices.get(prefixSum - k));
                }

                if(!indices.containsKey(prefixSum)){
                    indices.put(prefixSum,i);
                }

            }
            return maxLen;
        }
    }
}
