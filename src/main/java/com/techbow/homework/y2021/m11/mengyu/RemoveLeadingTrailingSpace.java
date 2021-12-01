package com.techbow.homework.y2021.m11.mengyu;

public class RemoveLeadingTrailingSpace {
    //S1:    keep the space after the word
    // you_get_offer_ffer___
    //               s
    //                     f
    public String removeSpaces(String s) {
        char[] sChar = s.toCharArray();
        int slow = 0;
        int fast;
        for (fast = 0; fast < s.length(); fast++) {
            if (sChar[fast] == ' ' && (fast == 0 || sChar[fast - 1] == ' ')) {
                continue;
            } else {
                sChar[slow++] = sChar[fast];
            }
        }
        if (sChar[fast - 1] == ' ') {
            return new String(sChar, 0, slow - 1);
        }
        return new String(sChar, 0, slow);
    }

    public static void main(String[] args) {
        RemoveLeadingTrailingSpace test = new RemoveLeadingTrailingSpace();
        String testString = "   I  will    get   offer";
        System.out.println(test.removeSpaces(testString));
    }
}
