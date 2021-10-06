package com.techbow.homework.y2021.m09.ludai;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maximumearining {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (o1, o2) -> o1[1]-o2[1]);
        List<long[]> dp = new ArrayList<>();
        dp.add(new long[] {-1,0});
        int i = 0;
        long res = 0;
        while (i < rides.length){
            long cur = res;
            int idx = lowerBound(dp, rides[i][0]);
            cur=Math.max(cur,dp.get(idx)[1]-rides[i][0]+rides[i][1]+rides[i][2]);
            res = Math.max(cur,res);
            dp.add(new long[] {rides[i][1], cur});
            i++;
        }
        return res;
    }
    private int lowerBound(List<long[]> dp, int t) {
        int left = 0, right = dp.size()-1;
        while (left < right) {
            int mid = right - (right -left)/2;
            if (dp.get(mid)[0] <= t ) left =mid;
            else right =right -1;

        }
        return dp.get(left)[0]<= t? left: left-1;
    }
}
}
