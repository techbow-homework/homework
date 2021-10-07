package com.techbow.homework.y2021.m09.cma;

public class LC275 {class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0, med = 0, end = len - 1;
        while(start <= end){
            med = start + (end - start)/2;

            if(citations[med] == len - med){
                return len-med;
            }else if(citations[med] < len - med){
                start = med + 1;
            } else{
                end = med - 1;
            }
        }
        return len -start;
    }
}
}
