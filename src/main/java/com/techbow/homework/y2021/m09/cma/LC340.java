package com.techbow.homework.y2021.m09.cma;

public class LC340 {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int[] count = new int[256];
            int max = 0, left = 0, numDis = 0;
            for(int right = 0; right < s.length(); right ++){
                char ch = s.charAt(right);
                if(count[ch] == 0){
                    numDis ++;
                }
                count[ch] ++;
                while(numDis > k){
                    count[s.charAt(left)] --;
                    if(count[s.charAt(left)] == 0){
                        numDis --;
                    }
                    left ++;

                }
                max = Math.max(max, right-left + 1);
            }
            return max;
        }
    }
}
