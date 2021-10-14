package com.techbow.homework.y2021.m10.zekun;

public class LC0010_DFS_Expressions {
    public static void main(String[] args){
        LC0010_DFS_Expressions obj = new LC0010_DFS_Expressions();
        String sstring = "aab";
        String pstring = "c*a*b";
        boolean sol = obj.isMatch(sstring,pstring);
        System.out.println(sol);
    }
    public boolean isMatch(String s, String p) {
        //cc
        if(s == null || p == null || s.length() == 0 || p.length() == 0) return false;

        int sind = 0; // a index 遍历s
        int pind = 0;
        return dfs(s, p, sind, pind);
    }

    private boolean dfs(String s, String p, int sind, int pind){
        //base case
        //success
        if(pind == p.length()) return sind == s.length();

        //check visited: no need
        //recursion body
        for(int i = pind; i < p.length(); i++){
            char chp = p.charAt(i);

            for(int j = sind; j < s.length(); j++){
                if(chp == '.'){
                    return dfs(s, p, j + 1, i + 1);
                }else if(chp == '*'){

                    return dfs(s, p, j + 1, i);
                }else{
                    if(p.charAt(i) == s.charAt(j)){
                        return dfs(s, p, j + 1, i + 1);
                    }else{
                        return false;
                    }
                }
            }

        }
        return false;
    }
}
