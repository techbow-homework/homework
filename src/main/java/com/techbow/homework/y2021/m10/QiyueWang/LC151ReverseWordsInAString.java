package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC151ReverseWordsInAString {
    public static String reverseWords(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder cur = new StringBuilder();
            // while(i < n && s.charAt(i) == ' '){
            //     i++;
            // }
            while(i < n && s.charAt(i) != ' '){
                cur.append(s.charAt(i));
                i++;
            }
            if(cur.length() != 0){
                res.add(cur.toString());
            }
        }
        String ret = "";
        for(int i = res.size() - 1; i >= 0; i--){
            ret += res.get(i) + " ";
        }
        //System.out.println(res.toString());
        return ret.substring(0, ret.length() - 1);
    }

    public static void main(String[] args) {
        String s1 = "  hello world  ";
        System.out.println(reverseWords(s1));
        String s2 = "a good   example";
        System.out.println(reverseWords(s2));
    }
}
// time O(N) space O(N)
