package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC2032TwoOutOfThree {
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> res = new ArrayList<>();
        int[] buckets = new int[101];
        for(int i : nums1){
            if(buckets[i] == 0){
                buckets[i] = 1;
            }
        }
        for(int i : nums2){
            if(buckets[i] == 0){
                buckets[i] = 2;
            }else if(buckets[i] == 1){
                res.add(i);
                buckets[i] = -1;
            }
        }
        for(int i : nums3){
            if(buckets[i] == 1 || buckets[i] == 2){
                res.add(i);
                buckets[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,15,10,11,14,12,14,11,9,1};
        int[] nums2 = new int[]{8,9,13,2,11,8};
        int[] nums3 = new int[]{13,5,15,7,12,7,8,3,13,15};
        System.out.println(twoOutOfThree(nums1,nums2,nums3)); // [9,2,11,13,15,12,8]
    }
}
