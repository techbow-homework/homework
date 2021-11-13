package com.techbow.homework.y2021.m11.QiyueWang;
// find the probability of a target number by sum of n number of dice rolls
//
public class DiceSum {
    public double prob(int n, int target){
        int total = (int) Math.pow(6, n);
        int[] res = new int[1];
        dfs(n, target, res);
        return res[0] * 1.0/total;
    }
    private void dfs(int n, int target, int[] res){
        if(n == 0 && target == 0){
            res[0]++;
            return;
        }
        if(n == 0 || target <= 0){
            return;
        }
        for(int i = 1; i <= 6; i++){
            dfs(n - 1, target - i, res);
        }
    }
//----dfs with memorization-------
    public double prob2(int n, int target){
        int total = (int) Math.pow(6, n);
        int[][] mem = new int[n + 1][target + 1];
        return dfsMem(n, target, mem) * 1.0 / total;
    }
    private int dfsMem(int n, int target, int[][] mem){
        if(n == 0 && target == 0){
            return 1;
        }
        if(n == 0 || target <= 0 ){
            return 0;
        }
        if(mem[n][target] != 0){
            return mem[n][target];
        }
        int res = 0;
        for(int i = 1; i <= 6; i++){
            res += dfsMem(n - 1, target - i, mem);
        }
        mem[n][target] = res;
        return mem[n][target];
    }
    public static void main(String[] args) {
        DiceSum obj = new DiceSum();
        System.out.println(obj.prob(2,2));
        System.out.println(obj.prob2(2,2));
        System.out.println(obj.prob(4,12));
        System.out.println(obj.prob2(4,12));
    }
}
