package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 9999;//unkonwn right index
        while(left+1<right){
            int mid = left+(right-left)/2;
            if( reader.get(mid)> 10000){
                right = mid -1;
            }else{
                left = mid;
            }
        }
        left = 0;
        int counter = 0;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(reader.get(mid) < target){
                left = mid + 1;
            }else if(reader.get(mid) > target){
                right = mid -1;
            }else{
                counter++;
                return mid;
            }
        }
        if(counter == 0){
            return -1;
        }
        return right;
    }
}