
package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0301_DFS_removeParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();//用hashset查重；
        //cc
        if(s == null || s.length() == 0) return new ArrayList<String>(res);

        int[] rm = checkMinRemParentheses(s);
        StringBuilder path = new StringBuilder();
        dfs(res, path, s, 0, rm[0], rm[1], 0);
        return new ArrayList<String>(res);//最后把hashset转换成ArrayList;
    }

    private void dfs(Set<String> res, StringBuilder path, String str, int index, int rmL, int rmR, int delta){
        //success case
        int strLen = str.length();
        if(index == strLen && delta == 0 && rmL == 0 && rmR == 0){
            res.add(path.toString());
            return;
        }
        //fail case
        if(index >= strLen || delta < 0 || rmL < 0|| rmR < 0){
            return;
        }

        //visited? no need
        //
        char ch = str.charAt(index);
        int pathLen = path.length();
        if(ch == '(') {
            //remove
            dfs(res, path, str, index + 1, rmL - 1, rmR, delta);
            //keep
            path.append('(');
            dfs(res, path, str, index + 1, rmL, rmR, delta + 1);
            path.setLength(pathLen);

        }else if(ch == ')') {
            //remove
            dfs(res, path, str, index + 1, rmL, rmR - 1, delta);

            //keep
            path.append(')');
            dfs(res, path, str, index + 1, rmL, rmR, delta - 1);
            path.setLength(pathLen);
        }else{
            path.append(ch);
            dfs(res, path, str, index + 1, rmL, rmR, delta);
            path.setLength(pathLen);
        }
        //这题不用for loop，因为不需要拼数！for loop 用于，do 或者不 do 然后要拼数;

    }

    private int[] checkMinRemParentheses(String s){
        int rmL = 0;
        int rmR = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                rmL++;
            }else if(ch == ')'){
                if(rmL > 0){
                    rmL--;
                }else{
                    rmR++;
                }
            }else{
                continue;
            }
        }
        return new int[] {rmL, rmR};
    }
}
