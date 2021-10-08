package com.techbow.homework.y2021.m09.cma;

public class LC464 {
    class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            int sum = (1 + maxChoosableInteger)*maxChoosableInteger/2;
            if(sum < desiredTotal){
                return false;
            }
            int map = (1<< maxChoosableInteger) - 1;
            Boolean mem[] = new Boolean[map + 1];
            return dfs(map, 0, desiredTotal, maxChoosableInteger, mem);

        }

        private boolean dfs(int map, int curSum, int desiredTotal, int maxChoosableInteger, Boolean[] mem){
            if(mem[map] != null){
                return mem[map];
            }

            for(int i = 1; i <=maxChoosableInteger; i++){
                int mask = 1<<(i-1);
                if((mask & map) != 0){
                    if(curSum + i >= desiredTotal){
                        return true;
                    }

                    if(!dfs(map - mask, curSum + i, desiredTotal, maxChoosableInteger, mem)){
                        mem[map] = true;
                        return true;
                    }
                }
            }
            mem[map] = false;
            return false;
        }
    }
}
