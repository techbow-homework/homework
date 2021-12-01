package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC119 {
    public List<Integer> getRow(int rowIndex) {
        /*
    0           1
    1         1   1
    2       1   2   1
    3     1   3   3   1

             1 3 3 1
                   j
         */
        List<Integer> row = new ArrayList<>();

        for (int rows = 0; rows < rowIndex + 1; rows++) {
            row.add(0, 1);
            for (int eleIdx = 1; eleIdx < row.size() - 1; eleIdx++) {
                row.set(eleIdx, row.get(eleIdx) + row.get(eleIdx + 1));
            }
        }
        return row;
    }
}
