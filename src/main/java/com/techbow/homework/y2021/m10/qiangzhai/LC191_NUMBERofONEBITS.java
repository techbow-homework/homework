package com.techbow.homework.y2021.m10.qiangzhai;

public class LC191_NUMBERofONEBITS {
    //s1:mask左移
    public int hammingWeight(int n) {
        int cnt = 0;
        int m = 1;
        for (int i = 0; i < 32; i++) {
            //m << i;
            if ((n & m << i ) != 0) {//不改变mask
                cnt++;
            }
            //m <<= 1;//改变mask
        }
        return cnt;
    }
    //s2:input右移
    public int hammingWeight(int n) {
        int cnt = 0;
        int m = 1;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) != 0)
                cnt++;
        }
        return cnt;
    }
    //s3:提前跳出，input>>>
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) != 0) cnt++;
            n >>>= 1;//无脑补0，等于0提前结束
        }
        return cnt;
    }
}
