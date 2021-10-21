package com.techbow.homework.y2021.m09.cma;

public class LC403 {
    class Solution {
        public boolean canCross(int[] stones) {
            if(stones == null || stones.length <=1){
                return false;
            }
            if(stones[1] - stones[0] != 1){
                return false;
            }

            HashMap<Integer, Boolean>[] mem = new HashMap[stones.length];
            for(int i = 0; i < stones.length; i ++){
                mem[i] = new HashMap<Integer, Boolean>();
            }
            return dfs(stones, 1,1,mem);
        }
        private boolean dfs(int[] stones, int idx, int k , HashMap<Integer, Boolean>[] mem){
            HashMap<Integer, Boolean> map = mem[idx];
            if(map.containsKey(k)){
                return map.get(k);
            }
            int len = stones.length;
            if(idx == len -1){
                return true;
            }

            for(int i = idx + 1; i < len; i ++){
                int dis = stones[i] - stones[idx];
                if(dis < k -1){
                    continue;
                }
                if(dis > k + 1){
                    break;
                }
                if(dis == k - 1 || dis == k|| dis == k+1){
                    if(dfs(stones, i , dis, mem)){
                        map.put(k ,true);
                        return true;
                    }
                }
            }
            map.put(k, false);
            return false;
        }
    }
}
