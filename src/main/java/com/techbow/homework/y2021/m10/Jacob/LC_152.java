package com.techbow.homework.y2021.m10.Jacob;

public class LC_152 {
    public int maxProduct(int[] a) {
      if (a == null || a.length == 0) return 0;
       int max = a[0];
       int min = a[0];
       int res = a[0];

       for (int i = 1; i <= a.length; i++) {
           int temp = max;
           max = Math.max(Math.max(max * a[i], min * a[i]), a[i]);
           min = Math.min(Math.min(max * a[i], temp * a[i]), a[i]);

           res = Math.max(res, max);
       }
       return res;
    }
}
