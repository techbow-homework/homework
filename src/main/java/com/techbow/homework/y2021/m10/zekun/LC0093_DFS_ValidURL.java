package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0093_DFS_ValidURL {
    public static void main(String[] args){
        String s = "25525511135";
        LC0093_DFS_ValidURL sol = new LC0093_DFS_ValidURL();
        List<String> res = sol.restoreIpAddresses(s);
        System.out.println(res);

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        //cc
        if(s == null || s.length() == 0 || s.length() > 12) return res;
        StringBuilder path = new StringBuilder();
        dfs(res, path, s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, String s, int index, int num){
        int strlen = s.length();

        if(num == 4){
            if(index == strlen){
               path.setLength(path.length()-1);
               res.add(path.toString());
            }
            return;
        }

        if(index >= strlen) return;

        // branches
        int pathlength = path.length();
        for(int l = 1; l <= 3; l++){//
            if(index + l > strlen) break;

            int val = Integer.valueOf(s.substring(index, index + l));

            if(val >= 0 && val <= 255){
                path.append(val + ".");
                dfs(res, path, s, index + l, num + 1);
                path.setLength(pathlength);
            }
            if(val == 0) break;
        }

    }
}
