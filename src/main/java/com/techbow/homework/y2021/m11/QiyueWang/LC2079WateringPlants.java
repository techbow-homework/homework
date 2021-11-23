package com.techbow.homework.y2021.m11.QiyueWang;

public class LC2079WateringPlants {
    public static int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            int curCap = capacity;
            res += 1 + i;// go to
            //System.out.println("i1 + 1: " + i + 1);
            if(i == n - 1) break; // last trip
            int j = i;
            while(j < n && curCap >= plants[j]){
                curCap -= plants[j];
                res++;
                j++;
            }
            res--;

            if(j == n) break;
            i = --j;
            res += i + 1;// go back

        }
        return res;
    }

    public static void main(String[] args) {
        int[] plants1 = new int[]{2,2,3,3};
        System.out.println(wateringPlants(plants1, 5));//14
        int[] plants2 = new  int[]{1,1,1,4,2,3};
        System.out.println(wateringPlants(plants2, 4));//30
    }
}
// time O(n) space O(1)
