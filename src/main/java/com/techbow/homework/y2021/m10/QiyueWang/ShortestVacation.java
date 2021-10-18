package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//DRW OA
public class ShortestVacation {
    public static int shortest(int[] A){
        int n = A.length;
        Set<Integer> allLocations = new HashSet<>();
        Map<Integer, Integer> countLocations = new HashMap<>();
        for(int i : A){
            allLocations.add(i);
        }
        int left = 0;
        int right = 0;
        while(!allLocations.isEmpty()){
            allLocations.remove(A[right]);
            int count = countLocations.getOrDefault(A[right],0);
            countLocations.put(A[right], count + 1);
            right ++;
        }
        int size = right - left;
        while (right < n){
            while(left <= right && countLocations.get(A[left]) > 1){
                int count = countLocations.get(A[left]);
                countLocations.put(A[left], count - 1);
                left++;
            }
            int cur = countLocations.getOrDefault(A[right], 0);
            countLocations.put(A[right], cur + 1);
            //System.out.println(left+" : "+right);
            size = Math.min(size, right - left);
            right++;
        }

        return size;
    }

    public static void main(String[] args) {
        int[] A1 = new int[]{7,3,7,3,1,3,4,1};
        int[] A2 = new int[]{2,1,1,3,2,1,1,3};
        int[] A3 = new int[]{7,5,2,7,2,7,4,7};
        System.out.println(shortest(A1));//5
        System.out.println(shortest(A2));//3
        System.out.println(shortest(A3));//6
    }
}
