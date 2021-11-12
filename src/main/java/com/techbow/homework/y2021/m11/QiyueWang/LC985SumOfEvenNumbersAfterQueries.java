package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;

public class LC985SumOfEvenNumbersAfterQueries {
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] res = new int[m];
        int sum = 0;
        for(int i : nums){
            if(i % 2 == 0){
                sum += i;
            }
        }
        for(int i = 0; i < m; i++){
            int prev = nums[queries[i][1]];
            int val = queries[i][0];
            if((val + prev) % 2== 0){
                sum +=  val + prev;
            }
            if(prev % 2 == 0){
                sum -= prev;
            }
            nums[queries[i][1]] = prev + val;
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[][] queries = new int[][]{{1,0},{-3,1},{-4,0},{2,3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(nums, queries)));//[8,6,2,4]
    }
}
// time O(m + n) space O(1)
