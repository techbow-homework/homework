package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0282_DFS_ExpressionOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        //cc
        if(num == null || num.length() == 0) return res;
        StringBuilder path = new StringBuilder();
        dfsHelper(num, target, path, res, 0, 0, 0);
        return res;
    }

    private void dfsHelper(String num, int target, StringBuilder path, List<String> res, int index, long sum, long lastVal){
        //base case
        //success
        int numLen = num.length();
        if(index == numLen){
            if(sum == target){
                res.add(path.toString());
            }
            return;
        }
        int pathLen = path.length();

        //visited? no needed
        //fencha
        long val = 0;
        for(int i = index; i < numLen; i++){
            val = val * 10 + num.charAt(i) - '0';
            if(index == 0){
                path.append(val);
                dfsHelper(num, target, path, res, i + 1, val, val);
                path.setLength(pathLen);
            }else{
                //+
                path.append("+" + val);
                dfsHelper(num, target, path, res, i + 1, sum + val, val);
                path.setLength(pathLen);

                //-
                path.append("-" + val);
                dfsHelper(num, target, path, res, i + 1, sum - val, -val);
                path.setLength(pathLen);

                //*
                path.append("*" + val);
                dfsHelper(num, target, path, res, i + 1, sum - lastVal + lastVal * val, lastVal * val);
                path.setLength(pathLen);
            }

            if(val == 0) break;


        }
    }

    public static class LC0078_DFS_Subset {
        public static void main(String[] args){
            int[] nums = new int[] {1,2,3};
            System.out.println(subsets(nums));

        }


        public static List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> nb = new ArrayList<>();
            dfs(nums, 0, res, nb);
            return res;
        }

        private static void dfs(int[] array, int index, List<List<Integer>> res,List<Integer> nb){
            res.add(new ArrayList<Integer>(nb));// 这里通过创建新object的形式，做了deep copy，不然的话是不对的；
            // 因为不deep copy的话，那往里加的都是同一个地址，然后recursion的最后，这个nb或者sb的状态是空的，
            // 因此最后如果灭有deep copy， 那么返回的都是同一个空的object的地址，所以结果是空的；

            for(int i = index; i < array.length; i++){
                nb.add(array[i]);
                dfs(array, i + 1, res, nb);
                nb.remove(nb.size() - 1);
            }
        }
    }
}
