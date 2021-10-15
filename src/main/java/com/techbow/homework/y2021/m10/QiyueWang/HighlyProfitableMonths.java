package com.techbow.homework.y2021.m10.QiyueWang;
// find the number of k consecutive increasing months
// price = {5,3,5,7,8}, k = 3
// num = 2  ( 123 and 234 )

public class HighlyProfitableMonths {
    public static int number(int[] price, int k){
        int n = price.length;
        if(n < k) return 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            int curLen = 1;
            while(i < n - 1 && price[i] < price[i + 1]){
                curLen++;
                i++;
            }
            if(curLen > k - 1){
                res += curLen - k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] p1 = {5,3,5,7,8,4,5,6};
        System.out.println(number(p1, 3)); // 3
        System.out.println(number(p1, 2)); // 5
        System.out.println(number(p1, 1)); // 8
    }
}
