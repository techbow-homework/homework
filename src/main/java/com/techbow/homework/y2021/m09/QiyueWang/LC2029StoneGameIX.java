package com.techbow.homework.y2021.m09.QiyueWang;

// Count the frequency of mod3 = 0,1,2.

// Firstly, don't consider the multiples of 3.
// Alice starts with mod3 = 1, Alice and Bob have to pick 1,1,2,1,2... in order.
// Alice starts with mod3 = 2, Alice and Bob have to pick 2,2,1,2,1... in order.

// If Alice starts with 2, then Alice needs 1 and Bob needs 2.
// If 1 is much more than 2, then Bob is going to lose.

// So if cnt[0] == 0, the result can be decided by Alice.

// Then, consider the number of multiples of 3.
// If cnt[0] is even,
// Bob picks a 3, Alice can always picks one another.
// the result won't be affected.

// If cnt[0] is odd,
// the final result will be reversed,
// (unless the case Bob wins for all numbers consumed)


public class LC2029StoneGameIX {
    public static boolean stoneGameIX(int[] stones) {
        int[] countMod = new int[3];
        for(int i : stones){
            countMod[i % 3]++;
        }
        if(Math.min(countMod[1], countMod[2]) == 0){
            return countMod[0] % 2 > 0 && Math.max(countMod[1], countMod[2]) > 2;
        }
        return countMod[0] % 2 == 0 || Math.abs(countMod[1] - countMod[2]) > 2;
    }
//time O(n) space O(1)

    public static void main(String[] args) {
        int[] stones = new int[]{5,1,2,4};
        int[] stones2 = new int[]{1,1,1,3};
        int[] stones3 = new int[]{1,3};
        System.out.println(stoneGameIX(stones)); //true
        System.out.println(stoneGameIX(stones2)); //true
        System.out.println(stoneGameIX(stones3)); //false
    }
}