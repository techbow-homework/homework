package com.techbow.homework.y2021.m12.mengyu;

public class LC152 {
    public int maxProductS1BruteForce(int[] nums) {
        //2 3 -2 4
        //  i
        //  j
        //int prev = 6
        //int max = Integer.MIN_VALUE;
        //corner case
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer prevProduct = null;
            int product = 0;
            for (int j = i; j < nums.length; j++) {
                if (prevProduct != null) {
                    product = prevProduct * nums[j];
                } else if (j == i) {
                    product = nums[i] * 1;
                } else {
                    product = nums[i] * nums[j];
                }

                max = product > max ? product : max;
                prevProduct = product;
            }
        }
        return max;
    }

    public int maxProductS2(int[] nums) {

        if(nums.length==1)
            return nums[0];

        int ans=Integer.MIN_VALUE;
        int currpro=1;

        for(int i=0;i<nums.length;i++){
            currpro*=nums[i];
            ans=Math.max(ans,currpro);
            if(currpro==0){
                currpro=1;
            }
        }

        currpro=1;

        for(int i=nums.length-1;i>=0;i--){
            currpro*=nums[i];
            ans=Math.max(ans,currpro);
            if(currpro==0){
                currpro=1;
            }
        }
        return ans;

    }

}
