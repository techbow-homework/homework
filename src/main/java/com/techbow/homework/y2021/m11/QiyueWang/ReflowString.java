package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;
// reflow
// [ "The day began as still as the",
//          "night abruptly lighted with",
//          "brilliant flame" ]
// to
//[ "The--day--began-as-still",
//        "as--the--night--abruptly",
//        "lighted--with--brilliant",
//        "flame" ] // <--- a single word on a line is not padded with spaces
// with maxLen = 24
// fill spaces with '-' as equally possible

public class ReflowString {
    public static List<String> reflow(String[] strs, int maxLen){
        List<String> sList = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for(String s : strs){
            String[] sArr = s.split(" ");
            for(String s0 : sArr){
                sList.add(s0);
            }
        }
        int count = -1;
        int totalLen = 0;
        List<String> temp = new ArrayList<>();
        for(String s : sList){
            int curLen = s.length();
            totalLen += curLen;
            count++;

            if(totalLen + count > maxLen){
                //System.out.println(totalLen +" "+ curLen + " "+ count);
                res.add(newString(temp, totalLen - curLen, count - 1, maxLen));
                count = 0;
                totalLen = curLen;
                temp = new ArrayList<>();
            }
            temp.add(s);
            //System.out.println(temp + "  " + count);
        }
        if(temp.size() != 0){
            res.add(newString(temp, totalLen, temp.size() - 1, maxLen));
        }
        return res;
    }
    private static String newString(List<String> temp, int curLen, int count, int maxLen){
        if(temp.size() == 0) throw new IllegalArgumentException("invalid input");
        if(count == 0) return temp.get(0);

        int num = (maxLen - curLen) / count;
        int offset = (maxLen - curLen) % count;
        StringBuilder sb = new StringBuilder();
        sb.append(temp.get(0));
        for(int i = 0; i < count; i++){
            for(int j = 0; j < num; j++) {
                sb.append('-');
            }
            if(i < offset){
                sb.append('-');
            }
            sb.append(temp.get(i + 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] line = new String[]{"The day began as still as the", "night abruptly lighted with","brilliant flame"};
        String[] line2 = new String[]{"The day began as still as the", "night abruptly lighted with","brilliant flame fly"};
        System.out.println(reflow(line, 24));
        System.out.println(reflow(line2, 24));
    }
}
