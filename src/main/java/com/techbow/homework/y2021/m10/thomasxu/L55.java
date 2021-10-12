package com.techbow.homework.y2021.m10.thomasxu;

public class L55 {
    //dp
    public boolean canJump(int[] nums) {
        if( nums== null || nums.length==0) return false;
        Boolean[]  check = new Boolean[nums.length];
        //base case
        check[nums.length-1] = true;
        // induction rule
        for(int i= nums.length-2; i>=0;i--){
            int cur= Math.min(i+nums[i], nums.length-1); //  保证 array[i+ nums[i]]不会出界
            for( int j=i+1;j<=cur;j++){
                if (check[j]==true){
                    check[i]=true;
                    break;
                }
            }
            if(check[i]==null){
                check[i]=false;
            }
        }
        return check[0]==true;
    }
    //greedy
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
