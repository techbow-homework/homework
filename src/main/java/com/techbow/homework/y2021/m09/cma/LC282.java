package com.techbow.homework.y2021.m09.cma;

public class LC282 {
    class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            dfs(res, new StringBuilder(), num, 0, target, 0, 0);
            return res;

        }
        //用long不是int
        private void dfs(List<String> res, StringBuilder path, String num, long idx, long target, long sum, long lastVal){

            int len = num.length();
            if(idx == len){
                if(sum == target){
                    res.add(path.toString());
                }
                return;
            }

            if(len == 0) return;

            long val = 0;
            int pathlen = path.length();

            for(int i = (int) idx; i < len; i ++){
                val = val * 10 + num.charAt(i) - '0';
                if(idx == 0){
                    path.append(val);
                    dfs(res, path, num, i + 1, target, val, val);
                    path.setLength(pathlen);

                } else{
                    path.append('+').append(val);
                    dfs(res, path, num, i + 1, target, sum + val, val);
                    path.setLength(pathlen);

                    path.append('-').append(val);
                    dfs(res, path, num, i + 1, target, sum - val, -val);
                    path.setLength(pathlen);

                    path.append('*').append(val);
                    dfs(res, path, num, i + 1, target, sum - lastVal + lastVal*val, lastVal*val);
                    path.setLength(pathlen);
                }


                if(val == 0){break;}
            }
        }
    }
}
