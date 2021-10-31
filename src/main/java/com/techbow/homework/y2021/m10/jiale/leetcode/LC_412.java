package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_412 {
    List<String> res = new ArrayList<>();
    public List<String> fizzBuzz(int n) {
        // 1,2,3,4,5,6,7
        if (n > 1) {
            fizzBuzz(n-1);
        }
        if (n % 5 == 0 && n % 3  == 0) {
            res.add("FizzBuzz");
        } else if (n % 5 == 0) {
            res.add("Buzz");
        } else if (n % 3 == 0) {
            res.add("Fizz");
        } else {
            res.add(String.valueOf(n));
        }
        return res;
    }
}
