package com.techbow.homework.y2021.m09.cma;

public class LC334 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = 0;
            for(int num : nums){
                third = num;

                if(num > second){
                    return true;
                } else if (num <= first){
                    first = num;
                } else{
                    second = num;
                }
                // System.out.println(first);
                // System.out.println(second);
                // System.out.println(third);
                // System.out.println(' ');
            }
            return false;
        }
    }
}
