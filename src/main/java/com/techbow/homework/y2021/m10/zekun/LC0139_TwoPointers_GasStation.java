package com.techbow.homework.y2021.m10.zekun;

public class LC0139_TwoPointers_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //cc
        if(gas == null || gas.length == 0) return -1;
        int start = gas.length, end = 0;
        int sum = 0;
        while(end < start){
            if(sum >= 0){
                sum += gas[end] - cost[end];
                end++;
            }else{
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? ((start == gas.length) ? 0 : start) : -1;
    }
}
