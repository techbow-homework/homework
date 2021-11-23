package com.techbow.homework.y2021.m10.ryanxu.LC_1286;

public class CombinationIterator {

    private String characters;
    private int combinationLength;
    private boolean flag;
    private String curStr;
    private String endStr;

    public CombinationIterator(String characters, int combinationLength) {

        this.characters = characters;
        this.combinationLength = combinationLength;
        this.flag = true;
        this.curStr = characters.substring(0, this.combinationLength);
        int len = characters.length();
        this.endStr = characters.substring(len - this.combinationLength);
    }

    public String next() {

        // find the start and end result
        if (flag) {
            this.flag = false;
            return curStr;
        }
        char[] cur = curStr.toCharArray();
        int len = characters.length();
        // find out the position which need to move in curStr
        int i = curStr.length() - 1;
        while (i >= 0 && curStr.charAt(i) ==  characters.charAt(len - this.combinationLength + i)) {
            i--;
        }
        // find out the position which need to be updated in characters
        int j = 0;
        while (curStr.charAt(i) != characters.charAt(j)) {
            j++;
        }
        // make a combination
        for (int k = i; k < curStr.length(); k++) {
            cur[k] = characters.charAt(j + 1 + k - i);
        }

        this.curStr = String.valueOf(cur);
        return this.curStr;
    }

    public boolean hasNext() {
        return !this.curStr.equals(this.endStr);
    }
}
