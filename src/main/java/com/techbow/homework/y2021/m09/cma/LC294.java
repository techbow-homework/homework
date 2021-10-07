package com.techbow.homework.y2021.m09.cma;

public class LC294 {
    class Solution {
        public boolean canWin(String currentState) {
            char[] cs = currentState.toCharArray();
            return dfs(cs, new HashMap<String, Boolean>());
        }
        private boolean dfs(char[] cs, HashMap<String, Boolean> mem){
            int len = cs.length;
            String b = new String(cs);
            Boolean val = mem.get(b);
            if(val != null){
                return val;
            }

            for(int i = 0; i < len -1; i ++){
                if(cs[i] == '+' && cs[i+1] == '+'){
                    cs[i] = '-';
                    cs[i+1] = '-';

                    boolean ret = dfs(cs,mem);

                    cs[i] = '+';
                    cs[i+1] = '+';
                    if(!ret){
                        mem.put(b,true);
                        return true;
                    }
                }
            }
            mem.put(b,false);
            return false;
        }
    }
}
