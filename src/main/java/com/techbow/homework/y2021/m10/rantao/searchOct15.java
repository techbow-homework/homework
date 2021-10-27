package com.techbow.homework.y2021.m10.rantao;

import java.util.Arrays;

public class searchOct15 {
    public class solutionOct15 {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            for(int i=0; i<citations.length;i++){
                if(citations[i]>=citations.length-i) return citations.length-i;
            }
            return 0;
        }
    }
}
