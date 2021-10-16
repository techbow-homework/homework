package com.techbow.homework.y2021.m09.cma;
import java.util.*;
public class LC300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> mylist = new ArrayList<>();
            int idx = 0;
            for(int num : nums){
                idx = binarySearch(mylist,num);
                if(idx < mylist.size()){
                    mylist.set(idx, num);
                }else{
                    mylist.add(num);
                }
            }
            return mylist.size();
        }
        private int binarySearch(List<Integer> mylist, int target){
            int start = 0, med = 0, med_value = 0, end = mylist.size()-1;
            while(start <= end){
                med = start + (end - start)/2;;
                med_value = mylist.get(med);
                if(med_value == target){
                    return med;
                } else if(med_value > target){
                    end = med - 1;
                } else{
                    start = med + 1;
                }
            }
            return start;
        }
    }
}
