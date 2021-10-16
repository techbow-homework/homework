package com.techbow.homework.y2021.m09.cma;
import java.util.*;
public class LC093 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();

            if (s.isEmpty() || s.length() > 12) {
                return res;
            }

            dfs(s, 0,0, new StringBuilder(), res);
            return res;
        }

        private void dfs(final String s, int idx, int part, StringBuilder path, final List<String> res) {
            if (idx == s.length() && part == 4) {
                path.setLength(path.length() - 1);
                res.add(path.toString());
                return;
            }

            if(idx == s.length() || part > 4){
                return;
            }
            int len = path.length();
            for (int i = idx; i < Math.min(s.length(), idx + 3); i++) {
                String str = s.substring(idx, i + 1);
                int val = Integer.valueOf(str);
                if(val >= 0 && val <= 255){
                    path.append(val).append('.');
                    dfs(s, i + 1, part + 1, path, res);
                    path.setLength(len);
                }

                if(val == 0) break;
            }
        }
    }
}
