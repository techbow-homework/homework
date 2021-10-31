package com.techbow.homework.y2021.m10.rantao;

public class searchOct14 {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        if(nums[l]<nums[r]|| nums.length==1) return nums[0];

        while(l+1<r){
            int m=(l+r)/2;
            if(nums[l]<nums[m]){
                l=m;
            }else {
                r=m;
            }
        }return nums[l]<nums[r]? nums[l]:nums[r];

    }
    public int findMin2(int[] nums) {
        int l=0;
        int r=nums.length-1;
        if(nums[l]<nums[r]|| nums.length==1) return nums[l];

        while(l+1<r){
            int m=(l+r)/2;
            if(nums[l]<nums[r]&&nums[l]<nums[m]) return nums[l];

            if(nums[l]>nums[m]){
                r=m;
            }else if(nums[l]==nums[m]){
                l++;
            }else
                l=m+1;
        }

        return nums[l]<nums[r]? nums[l]:nums[r];}

    public int findPeakElement(int[] nums) {
        /*
        consdier all the clues:
1. if  value[  i-1< i >i+1 ]----> I is peak
2.if  value [ i-1< I < i+1]----->num[i+1…n] must contain peak
3. if value[ i-1> i > i+1 ]-----> num[i-1….0] must contain peak
4. if value[ i-1> i < i+1 ] -----> both side must contain peak
1. no adjacent two numbers are the same
2. the two end of arrays are -infinity
3. can return any peak

         */
        if(nums.length==1) return 0;
        int l=0;
        int r=nums.length-1;
        while(l+1<r){
            int m= l+(r-l)/2;
            if(nums[m]>nums[m-1] && nums[m]>nums[m+1]) return m;

            else if(m-1>=0 && nums[m]>nums[m-1]){
                l=m+1;
            }else{
                r=m;
            }
        }return nums[l]>nums[r] ? l:r;
    }

}
