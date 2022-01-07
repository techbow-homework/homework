package com.techbow.homework.y2021.m10.ryanxu.LC_411;

import java.util.*;

public class LC_411 {

    private static class Cell implements Comparable<Cell> {
        private int len;
        private int mask;
        public Cell(int len, int mask) {
            this.len = len;
            this.mask = mask;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cell)) return false;
            Cell cell = (Cell) o;
            return len == cell.len && mask == cell.mask;
        }

        @Override
        public int hashCode() {
            return Objects.hash(len, mask);
        }

        @Override
        public int compareTo(Cell another) {
            return this.len - another.len;
        }
    }

    public String minAbbreviation(String target, String[] dictionary) {

        if (target == null || dictionary == null || target.length() == 0) {
            return "";
        }
        if (dictionary.length == 0) {
            return String.valueOf(target.length());
        }

        int m = target.length();
        HashSet<String> dictionarySet = new HashSet<>();
        for (String word : dictionary) {
            if (word.length() == m) {
                dictionarySet.add(word);
            }
        }

        // 1 mean keep
        List<Cell> len2Mask = new ArrayList<>();
        for (int mask = 0; mask < (1 << m); mask++) {
            len2Mask.add(new Cell(getLen(mask, m), mask));
        }
        Collections.sort(len2Mask);

        for (Cell cell : len2Mask) {
            String targetAbbr = getAbbr(cell.mask, target);
            boolean flag = false;
            for (String word : dictionarySet) {
                String wordAbbr = getAbbr(cell.mask, word);
                if (targetAbbr.equals(wordAbbr)) {
                    flag = true;
                }
            }
            if (!flag) {
                return targetAbbr;
            }
        }

        return "";
    }

    private String getAbbr(int mask, String word) {

        StringBuilder res = new StringBuilder();
        int m = word.length();
        for (int i = 0; i < m; i++) {
            if (((mask >> i) & 1) == 1) {
                res.append(word.charAt(i));
            } else {
                int j = i;
                while (j < m && ((mask >> j) & 1) != 1) {
                    j++;
                }
                res.append(String.valueOf(j - i));
                i = j - 1;
            }
        }
        return res.toString();
    }

    private int getLen(int mask, int m) {

        int res = 0;
        for (int i = 0; i < m; i++) {
            if (((mask >> i) & 1) == 1) {
                res++;
            } else {
                int j = i;
                while (j < m && ((mask >> j) & 1) != 1) {
                    j++;
                }
                res += String.valueOf(j - i).length();
                i = j - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_411 lc_411 = new LC_411();
        String target = "leetcode";
        String[] dictionary = {"lyftcode","leetcold","litecode","lietcode","leetccod","lyftcold"};
        System.out.println(Integer.valueOf("11000001", 2));
        System.out.println(lc_411.minAbbreviation(target, dictionary));
    }
}
