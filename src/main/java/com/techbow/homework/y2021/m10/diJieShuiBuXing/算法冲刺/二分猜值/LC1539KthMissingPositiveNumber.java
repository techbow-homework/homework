package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法冲刺.二分猜值;

// diff =  arr[mid] - (mid + 1); // 当前value - index - 1
// value： 2 3 4 7 11
//index：  0 1 2 3 4
//missing：1 1 1 3 6
public class LC1539KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        //cc
        int l = 0, r = arr.length -1;

        while( l <= r){
            int mid = l + ( r - l) / 2;
            int diff =  arr[mid] - (mid + 1); // 当前value - index - 1
            if(diff < k){//因为找的是missing 所以这个值肯定在arr里不存在，所以没有条件 diff==k
                l = mid + 1;
            }else{
                r = mid -1 ;
            }
        }
        return l + k; // 返回的是arr的值，不是index
    }
}
