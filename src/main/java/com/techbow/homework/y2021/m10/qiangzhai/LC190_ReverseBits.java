package com.techbow.homework.y2021.m10.qiangzhai;

public class LC190_ReverseBits {
    //S1a: 单边reverse；input自右向左，res自左向右
    public int reverseBits(int n) {
        //cc
        if (n == 0 || n == -1) return n;
        //
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {//check 1
                res |= 1 <<(31 - i);
            }
        }
        return res;
    }
}
