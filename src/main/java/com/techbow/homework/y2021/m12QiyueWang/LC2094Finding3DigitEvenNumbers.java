package com.techbow.homework.y2021.m12QiyueWang;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LC2094Finding3DigitEvenNumbers {
    public static int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> res = new TreeSet<>();
        int cur = 0;
        for(int i = 0; i < n; i++){
            cur = 0;
            if(digits[i] != 0){
                cur = 100 * digits[i];
                for(int j = 0; j < n; j++){
                    if(j != i){
                        int cur2 = cur + 10 * digits[j];
                        for(int k = 0; k < n; k++){
                            if(k != j && k != i && digits[k] % 2 == 0){
                                res.add(cur2 + digits[k]);
                            }
                        }
                    }
                }
            }
        }
        int[] ret = new int[res.size()];
        int count = 0;
        for(int i : res){
            ret[count] = i;
            count++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] digits1 = new int[]{2,1,3,0};
        System.out.println(Arrays.toString(findEvenNumbers(digits1)));//[102,120,130,132,210,230,302,310,312,320]
        int[] digits2 = new int[]{2,2,8,8,2};
        System.out.println(Arrays.toString(findEvenNumbers(digits2)));//[222,228,282,288,822,828,882]
    }
}
