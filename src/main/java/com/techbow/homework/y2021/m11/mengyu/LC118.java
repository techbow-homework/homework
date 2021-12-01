package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        /*
             1 4 6 4 1
                       j
         */
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int rowNumber = 0; rowNumber < numRows; rowNumber++) {
            row.add(0, 1);
            for (int eleIndex = 1; eleIndex < row.size() - 1; eleIndex++) {
                row.set(eleIndex, row.get(eleIndex) + row.get(eleIndex + 1));
            }
            triangle.add(new ArrayList<>(row));
        }
        return triangle;
    }
}
