package com.techbow.homework.y2021.m10.rantao;

public class searchOct22 {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target) return 0;
        int left=0;
        int right=1;
        int m=0;
        while(reader.get(right)<target){
            left=right;
            right=right*2;
        }

        while(left<=right){
            m=left+(right-left)/2;
            if(reader.get(m)==target) return m;
            if(reader.get(m)>target){
                right=m-1;
            }if(reader.get(m)<target){
                left=m+1;
            }
        }return -1;

    }
}
