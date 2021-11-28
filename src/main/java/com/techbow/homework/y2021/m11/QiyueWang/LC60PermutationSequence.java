package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC60PermutationSequence {
//我们首先确定排列中的首个元素 a_1。根据上述的结论，我们可以知道：
// 以 1 为 a_1 的排列一共有 (n-1)! 个；
// 以 2 为 a_1 的排列一共有 (n-1)! 个；
// ......
// 以 n 为 a_1 的排列一共有 (n-1)! 个。

    public static String getPermutation(int n, int k) {
        int[] factorials = new int[n + 1];
        List<Integer> nums = new ArrayList<>(); // nums not selected
        factorials[0] = 1;
        for(int i = 1; i <= n; i++){
            factorials[i] = factorials[i - 1] * i;
            nums.add(i);
        }

        k = k - 1; // total k - 1 times

        StringBuilder res = new StringBuilder();
        for(int i = n - 1; i >= 0; i--){
            int index = k / factorials[i];//select the num at index
            k -= index * factorials[i]; // next pick from the offset

            res.append(nums.remove(index)); // remove the nums from remaining for next pick
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));//213
        System.out.println(getPermutation(4,9)); // 2314
    }
}
// time O(n^2) because deletion takes O(n)  space O(n)
