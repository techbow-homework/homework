package com.techbow.homework.y2021.m10.QiyueWang;

public class LC1375BulbSwitcherIII {
    public static int numTimesAllBlue(int[] light) {
        int n = light.length;
        int[] on = new int[n + 1];
        on[0] = 1;
        int minNotOn = 1;
        int farthest = 0;
        int res = 0;
        for(int i : light){
            on[i] = 1;
            farthest = Math.max(farthest, i);
            if(i == minNotOn){
                while(minNotOn <= n && on[minNotOn] == 1){
                    minNotOn ++;
                }
                if(minNotOn >= farthest){
                    res++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] light = new int[]{2,1,3,5,4};
        int[] light2 = new int[]{3,2,4,1,5};
        int[] light3 = new int[]{4,1,2,3};
        int[] light4 = new int[]{2,1,4,3,6,5};
        int[] light5 = new int[]{1,2,3,4,5,6};
        System.out.println(numTimesAllBlue(light));//3
        System.out.println(numTimesAllBlue(light2));//2
        System.out.println(numTimesAllBlue(light3));//1
        System.out.println(numTimesAllBlue(light4));//3
        System.out.println(numTimesAllBlue(light5));//6

    }
}
//time O(N) space O(N)
