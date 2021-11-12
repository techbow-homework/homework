package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC68TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int count = -1;
        int curLen = 0;
        List<String> cur = new ArrayList<>();
        for(int i = 0; i < n; i++){
            curLen += words[i].length();
            count ++;
            if(curLen + count  > maxWidth){
                res.add(parse(cur, maxWidth, curLen - words[i].length()));
                curLen = words[i].length();
                cur = new ArrayList<>();
                count = 0;
            }
            cur.add(words[i]);
            //System.out.println(cur + " " + curLen + " " + count);
        }
        if(cur.size() != 0){// still left last line
            StringBuilder sb = new StringBuilder();
            String temp = String.join(" ", cur);
            for(int i = 0; i < maxWidth - temp.length(); i++){
                sb.append(" ");
            }
            res.add(temp + sb.toString());
        }
        return res;
    }
    private static String parse(List<String> l, int maxWidth, int curLen){
        int count = l.size();
        StringBuilder res = new StringBuilder();
        res.append(l.get(0));
        if(count == 1){
            for(int i = 0; i < maxWidth - curLen; i++){
                res.append(" ");
            }
            return res.toString();
        }
        int num = (maxWidth - curLen) / (count - 1);
        int mod = (maxWidth - curLen) % (count - 1);
        //System.out.println(num+ " " + mod + l);

        for(int i = 0; i < count - 1; i++){

            if(i < mod){
                res.append(" ");
            }
            for(int j = 0; j < num; j++){
                res.append(" ");
            }
            res.append(l.get(i + 1));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] line = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] line2 = new String[]{"What","must","be","acknowledgment","shall","be"};
        String[] line3 = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(fullJustify(line, 16));
        System.out.println(fullJustify(line2, 16));
        System.out.println(fullJustify(line3, 20));
    }
}
