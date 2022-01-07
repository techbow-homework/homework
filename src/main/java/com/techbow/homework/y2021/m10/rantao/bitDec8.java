package com.techbow.homework.y2021.m10.rantao;

public class bitDec8 {
    public int hammingWeightS3(int n) {
        int count = 0;
        while( n != 0){
            if((n & 1) == 1) {
                count +=1;
            }
            n >>>=1;
        }
        return count;
    }
    public int hammingWeightS2(int n) {
        int count = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++){
            if((n & mask) ==1 ) count++;
            mask <<=1;
            // if( (n & mask <<i) != 0) count++;
        }
        return count;
    }
    public int hammingWeightS1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1 ) count++;
             n >>= 1;
        }
        return count;
    }

}
