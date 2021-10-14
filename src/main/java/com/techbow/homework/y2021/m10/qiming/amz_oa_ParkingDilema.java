package com.techbow.homework.y2021.m10.qiming;
//Amazon 2021 New Grad OA
//Find the minimum length of the roof that covers K cars.
//You are given an List of positions of cars as to where they are parked. You are also given an integer K.
//The cars needs to be covered with a roof. You have to find the minimum length of roof that takes to cover K cars.
//
//Input : 12,6,5,2      K = 3
//
//Explanation :  There are two possible roofs that can cover K cars. One that covers the car in 2,5,6 parking
//spots and another roof which covers 5,6,12 parking spots. The length of these two roofs are 5 and 8 respectively. Return 5
//
//since that's the roof with minimum length that covers K cars.
//
//Output : 5

import java.util.Arrays;

public class amz_oa_ParkingDilema {
    public static void main(String[] args) {

        int [] input = {12,6,5,2};
        int k = 3;
        System.out.println(solution(input, k));
    }

    public static int solution(int[] cars, int k){
        int res = Integer.MAX_VALUE;
        Arrays.sort(cars);
        for(int start = 0, end = k - 1; end < cars.length; start++, end++){
            res = Math.min(res, cars[end] - cars[start] + 1);
        }
        return res;
    }


}
