/** A = [2, 3, 1, 1, 0] return true
 *  A = [3, 2, 1, 0, 4] return false
 *                      2
 *                  /       \
 *                 3         1
 *            /    |   \     |
 *           1     1   0     1
 *           |     |         |
 *           1     0         0
 *           |
 *           0
 */
package com.techbow.homework.y2021.m10.shengyuan;

public class LC_55 {
    //S1: Recursion
    public boolean canJump(int[] array, int index) {
        //base case
        if (index >= array.length - 1) {
            return true;
        }
        int jump = array[index];
        for (int i = 1; i <= jump; i++) {               //for loop從左至右
            if (canJump(array, index + i)) {
                return true;
            }
        }
        return false;
    }
    //S2: DP (由右往左填值)
    public boolean jumpGame(int[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        int n = array.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= array[i]; j++) {
                if (i + j < n && dp[i + j]) {
                    dp[i] = true;
                    break;                          //一旦為true，可以直接跳出內層for loop
                }
            }
        }
        return dp[0];
    }
    //S3: DP (由右往左填值)
    public boolean canJump(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        if (array.length == 1) {
            return true;
        }
        int n = array.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = array[i]; j >= 1; j--) {
                if (i + j >= n - 1 || dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    //S4: Greedy
    public boolean canJump1(int[] array) {
        //cc
        if (array == null || array.length == 0) {
            return false;
        }
        int maxRange = 0;
        for (int i = 0; i <= maxRange; i++) {
            maxRange = Math.max(maxRange, i + array[i]);
            if (maxRange >= array.length - 1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LC_55 test = new LC_55();
        int[] array = {2, 3, 1, 1, 0};
        boolean res = test.jumpGame(array);
        System.out.println(res);
    }
}
