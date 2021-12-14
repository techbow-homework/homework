package com.techbow.homework.y2021.m10.zekun;

public class LC0149_MaximumPointsInSameLine {
    public int maxPoints(int[][] points){
        //cc
        if(points == null || points.length == 0) return 0;
        int np = points.length;
        int ans = 1;
        for(int i = 0; i < np; i++){//固定一个点
            int[] p1 = points[i];
            for(int j = i + 1; j < np; j++){//再固定一个点；
                int[] p2 = points[j];
                int curCount = 2;
                for(int k = j + 1; k < np; k++){
                    int[] p3 = points[k];
                    int s1 = (p2[1] - p1[1]) * (p3[0] - p2[0]);//交叉相乘了一下；
                    int s2 = (p2[0] - p1[0]) * (p3[1] - p2[1]);
                    if(s1 == s2){
                        curCount++;
                    }
                }
                ans = Math.max(ans, curCount);
            }
        }
        return ans;
    }
}
