package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.Arrays;

public class LC492ConstructTheRectangle {
    public static int[] constructRectangle(int area) {
        int[] res = new int[2];
        int sqrt = (int) Math.sqrt(area);
        for(int i = sqrt; i >= 1; i--){
            if(area % i == 0){
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int area1 = 4;
        int area2 = 37;
        int area3 = 122122;
        System.out.println(Arrays.toString(constructRectangle(area1))); // [2,2]
        System.out.println(Arrays.toString(constructRectangle(area2))); // [37, 1]
        System.out.println(Arrays.toString(constructRectangle(area3))); // [427,286]
    }
}
// time O(sqrt(n)) space O(1)
