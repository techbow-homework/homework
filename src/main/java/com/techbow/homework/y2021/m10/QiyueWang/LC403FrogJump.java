package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.HashMap;

public class LC403FrogJump {
    public static boolean canCross(int[] stones) {
        HashMap<Integer, Boolean>[] mem = new HashMap[stones.length];
        for(int i = 0; i < stones.length; i++){
            mem[i] = new HashMap<>();
        }
        return dfs(stones, 0, 0, mem);
    }
    private static boolean dfs(int[] stones, int index, int k, HashMap<Integer, Boolean>[] mem){
        if(index == stones.length - 1) return true;

        HashMap<Integer, Boolean> cur = mem[index];
        Boolean val = cur.get(k);
        if(val != null) return val;

        for(int i = index + 1; i < stones.length; i++){
            int distance = stones[i] - stones[index];
            if(distance < k - 1) continue;
            else if(distance > k + 1) break;
            else{
                if(dfs(stones, i, distance, mem)){
                    cur.put(k, true);
                    return true;
                }
            }
        }
        cur.put(k, false);
        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        int[] stones2 = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones));//true
        System.out.println(canCross(stones2));//false
    }
}
//O(N*k) space O(N)
