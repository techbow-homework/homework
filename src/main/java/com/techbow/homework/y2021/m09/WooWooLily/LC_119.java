package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;
//pascal's triangle
// 1
// 1 1
// 1 2 1
// 1 3 3 1
public class LC_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) return res;

        for (int r = 0; r <= rowIndex; r++) {
            res.add(1);
            for (int c = r-1; c > 0; c--) {
                res.set(c, res.get(c-1) + res.get(c));
            }
        }

        return res;

    }
}
