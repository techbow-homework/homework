package com.techbow.homework.y2021.m09.cma;

public class LC069 {
    class Solution {
        public int mySqrt(int x) {
            if(x<2){
                return x;
            }
            int start = 1, end = x/2;
            while(start <= end){
                int med = start + (end - start)/2;
                if(med <= x/ med && (med+1) > x/(med+1)){
                    return med;
                } else if (med > x / med){
                    end = med - 1;
                } else{
                    start = med + 1;
                }
            }
            return 0;
        }
    }
}
