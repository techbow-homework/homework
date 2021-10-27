package com.techbow.homework.y2021.m10.QiyueWang;

public class LC464CanIWin {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;

        int pool = (1 << maxChoosableInteger) - 1; // 1 for not chosen
        Boolean[] mem = new Boolean[pool + 1];
        return dfs(maxChoosableInteger, desiredTotal, pool, mem);
    }
    private static boolean dfs(int maxCh, int remain, int pool, Boolean[] mem){
        if(mem[pool] != null) return mem[pool];

        for(int i = 1; i <= maxCh; i++){
            int mask = 1 << (i - 1);
            if((pool & mask) != 0){
                if( remain - i <= 0|| !dfs(maxCh, remain - i, pool ^ mask, mem)){
                    //System.out.println(remain+"  "+i);
                    mem[pool] = true;
                    return true;
                }
            }
        }
        //System.out.println(remain);
        mem[pool] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canIWin(2,3)); //false
    }
}
// time O(maxCh) space O(2^maxCh)