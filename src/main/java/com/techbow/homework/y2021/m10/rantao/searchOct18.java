package com.techbow.homework.y2021.m10.rantao;

public class searchOct18 {
    public int firstBadVersion(int n) {
        if(n==1 && isBadVersion(n)) return 1;
        int left=1;
        int right= n;
        while(left<right){
            int m=left+(right-left)/2;
            if(isBadVersion(m)==true){
                right=m;
            }else left=m+1;
        }return left;
    }
}
