package com.techbow.homework.y2021.m10.ryanxu.LC_68;

import java.util.ArrayList;
import java.util.List;

public class LC_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        if (words == null) {
            return res;
        }

        int slow = 0;
        int fast = 0;
        int len = words.length;
        while (slow < len) {
            // 确定当前行可以放哪几个单词
            int curLineLength = words[fast].length();
            fast++;
            while (fast < len) {
                if (curLineLength + words[fast].length() + 1 > maxWidth) {
                    break;
                }
                curLineLength += (words[fast].length() + 1);
                fast++;
            }

            int numOfGap = fast - slow - 1;
            StringBuilder temp = new StringBuilder();
            // one word
            if (numOfGap == 0) {
                temp.append(words[slow]);
                for (int i = 0; i < maxWidth - curLineLength; i++) {
                    temp.append(" ");
                }
                res.add(temp.toString());
                slow = fast;
                continue;
            }


            // last row
            if (curLineLength < maxWidth && fast == len) {
                for (int i = slow; i < fast; i++) {
                    temp.append(words[i]).append(" ");
                }
                int resSpace = maxWidth - temp.length();
                for (int i = 0; i < resSpace; i++) {
                    temp.append(" ");
                }
                slow = fast;
                res.add(temp.toString());
                continue;
            }
            // normal
            int numOfGapsBetweenWords = (maxWidth - curLineLength + numOfGap) / numOfGap;
            int extraGaps = (maxWidth - curLineLength + numOfGap) % numOfGap;
            for (int i = slow; i < fast; i++) {
                temp.append(words[i]);
                for (int j = 0; j < numOfGapsBetweenWords; j++) {
                    temp.append(" ");
                }
                if (i < slow + extraGaps) {
                    temp.append(" ");
                }
            }
            slow = fast;
            temp.setLength(maxWidth);
            res.add(temp.toString());
        }

        return res;
    }
}
