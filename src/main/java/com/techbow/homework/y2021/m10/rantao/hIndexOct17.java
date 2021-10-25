package com.techbow.homework.y2021.m10.rantao;

public class hIndexOct17 {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        if(citations.length==1) return citations[0]==0? 0:1;
        int l=0;
        int r=citations.length-1;
        int len=citations.length;
        while(l<=r){
            int m= l+(r-l)/2;
            if((len-m)==citations[m]) return len-m;
            if((len-m)>citations[m]){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return len-l;
    }

}
