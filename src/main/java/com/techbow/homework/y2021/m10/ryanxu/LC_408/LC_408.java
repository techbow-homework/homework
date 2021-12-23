package com.techbow.homework.y2021.m10.ryanxu.LC_408;

public class LC_408 {
    public boolean validWordAbbreviation(String word, String abbr) {

        if (word == null && abbr == null) {
            return true;
        }

        if (word == null || abbr == null) {
            return false;
        }

        int wordLen = word.length();
        int abbrLen = abbr.length();
        int wordIdx = 0;
        int abbrIdx = 0;
        while (abbrIdx < abbrLen) {

            if (wordIdx >= wordLen) {
                return false;
            }
            if (abbr.charAt(abbrIdx) == '0') {
                return false;
            }
            if (abbr.charAt(abbrIdx) < '0' || abbr.charAt(abbrIdx) > '9') {
                if (abbr.charAt(abbrIdx) != word.charAt(wordIdx)) {
                    return false;
                }
                wordIdx++;
                abbrIdx++;
            } else if (abbr.charAt(abbrIdx) >= '0' && abbr.charAt(abbrIdx) <= '9') {
                int num = 0;
                while (abbrIdx < abbrLen && abbr.charAt(abbrIdx) >= '0' && abbr.charAt(abbrIdx) <= '9') {
                    num = num * 10 + abbr.charAt(abbrIdx) - '0';
                    abbrIdx++;
                }
                wordIdx += num;
            }
        }

        return wordIdx == wordLen;
    }

    public static void main(String[] args) {
        LC_408 lc_408 = new LC_408();
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(lc_408.validWordAbbreviation(word, abbr));
    }
}
