package com.techbow.homework.y2021.m11.QiyueWang;

public class LC392IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[lt + 1][26]; // dp[i][j]: start from position i, the next position of char j. if equals lt, then no more char j in t.
        for(int i = 0; i < 26; i++){ // on the boundary
            dp[lt][i] = lt;
        }

        for(int i = lt - 1; i >= 0; i--){
            for(int j = 0; j < 26; j++){
                if(t.charAt(i) == j + 'a'){ // has the char, then i is the position
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i + 1][j]; // ask for later, if no, at last dp[i][j] will equal lt.
                }
            }
        }
        int pos = 0;
        for(int i = 0; i < ls; i++){
            char c = s.charAt(i);
            if(dp[pos][c - 'a'] == lt){
                return false;
            }
            pos = dp[pos][c-  'a'] + 1;// go to the position of c, then move to the next index
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));//t
        System.out.println(isSubsequence("axc","ahbgdc"));//f
    }
}
// time O(ls + lt * 26) space O(lt * 26)
