package com.techbow.homework.y2021.m11.QiyueWang;

public class LC2078TwoFurthestHousesWithDifferentColors {
    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int i = n - 1;
        int j = 0;
        while(colors[0] == colors[i]){
            i--;
        }
        while(colors[n - 1] == colors[j]){
            j++;
        }
        return Math.max(i, n - 1 - j);
    }

    public static void main(String[] args) {
        int[] c1 = new int[]{1,1,1,6,1,1,1};
        int[] c2 = new int[]{1,8,3,8,3};
        int[] c3 = new int[]{0,1};
        System.out.println(maxDistance(c1));// 3
        System.out.println(maxDistance(c2));//4
        System.out.println(maxDistance(c3)); //1
    }
}
// time O(n) space O(1)
