package com.techbow.homework.y2021.m09.cma;

public class LC010 {
    class Solution {
        public boolean isMatch(String s, String p) {
            if( s == null || p == null){
                return false;
            }
            int lenP = p.length();
            int lenS = s.length();
            Boolean[][] mem = new Boolean[lenS+1][lenP+1];
            return dfs(s, 0 ,p, 0, mem);
        }

        private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] mem){
            int lenP = p.length();
            int lenS = s.length();
            if(mem[idxS][idxP] != null){
                return mem[idxS][idxP];
            }

            if(idxP == lenP){
                return idxS == lenS;
            } else if(idxP == lenP - 1 || p.charAt(idxP + 1) != '*'){
                if(idxS < lenS && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))){
                    mem[idxS][idxP] = dfs(s, idxS + 1, p ,idxP + 1, mem);
                } else{
                    mem[idxS][idxP] = false;
                    return false;
                }
            } else{
                int i = idxS - 1;
                while(i < lenS && (i < idxS|| p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(i) ) ){
                    if(dfs(s, i + 1, p ,idxP + 2, mem)){
                        mem[idxS][idxP] = true;
                        return true;
                    }
                    i++;
                }
                mem[idxS][idxP] = false;
            }
            return mem[idxS][idxP];
        }
    }
}
