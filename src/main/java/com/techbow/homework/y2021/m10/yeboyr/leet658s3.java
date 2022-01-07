package com.techbow.homework.y2021.m10.yeboyr;

import java.util.ArrayList;
import java.util.List;

public class leet658s3 {
    class Solution {

        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            List<Integer> result = new ArrayList<Integer>();

            //cc
            if(arr.length==k){
                for(int i = 0; i<k; i++){
                    result.add(arr[i]);
                }

                return result;

            }

            int start = this.findTarget(arr, x);
            int end = this.findTarget(arr, x);

            while(end - start - 1<k){
                if(start==-1){
                    end += 1;
                    continue;
                }

                if(end==arr.length||Math.abs(arr[start]-x)<=Math.abs(arr[end]-x)){
                    start -= 1;
                }
                else{
                    end += 1;
                }

            }

            for(int i = start+1;i<end;i++){
                result.add(arr[i]);
            }

            return result;
        }

        public int findTarget(int[] arr, int x){
            int left = 0;
            int len = arr.length;
            int right = len - 1;
            int mid;

            while(left<=right){
                mid = left + (right-left)/2;
                if(arr[mid]==x)
                    return mid;
                else if(arr[mid]<x)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            return Math.abs(arr[left]-x)<Math.abs(arr[right]-x)?left:right;
        }

    }
}
/*
传入instance时不需要传入数据类型
 */
