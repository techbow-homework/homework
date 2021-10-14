package com.techbow.homework.y2021.m10.rantao;
public class mySqrt {
    public static int mySqrtBinary(int x) {
        int l=1;
        int r=x;
        if(x==0) return 0;
        while(l<r){
            int m=(l+r)/2;
            if(m<=(x/m)&&(m+1)>(x/(m+1))){  // find critical point where m^2 < target
                return m;
            }
            else if(m>(x/m)){
                r=m;
            }
            else {
                l=m;
            }
        }return l;
    }

    public static void main(String[] args){
        System.out.println(mySqrtBinary(0));
    }
}

