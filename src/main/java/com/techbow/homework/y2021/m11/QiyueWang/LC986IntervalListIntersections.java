package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC986IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] la, int[][] lb) {
        if(la.length == 0 || lb.length == 0) return new int[0][0];
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < la.length && j < lb.length){
            int left = Math.max(la[i][0], lb[j][0]);
            int right = Math.min(la[i][1], lb[j][1]);
            if(left <= right){// have to compare
                res.add(new int[]{left, right});
            }
            if(la[i][1] < lb[j][1]){// move forward
                i++;
            }else{
                j++;
            }
        }
        // int[][] ret = new int[res.size()][2];
        // int k = 0;
        // for(int[] r : res){
        //     ret[k++] = r;
        // }
        // return ret;
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] fl = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] sl = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(intervalIntersection(fl,sl)));//[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    }
}
//time O(m + n) space O(m + n)
