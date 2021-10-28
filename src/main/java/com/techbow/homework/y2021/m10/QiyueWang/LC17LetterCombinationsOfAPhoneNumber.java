package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC17LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        String[] map = new String[] {"-", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs(digits, 0, map, new StringBuilder(), res);
        return res;
    }
    private static void dfs(String digits, int index, String[] map, StringBuilder cur, List<String> res){
        if(index == digits.length()){
            res.add(cur.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        String curGroup = map[num];
        for(int i = 0; i < curGroup.length(); i++){
            cur.append(curGroup.charAt(i));
            dfs(digits, index + 1, map, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        String digits2 = "2324";
        System.out.println(letterCombinations(digits1));
        System.out.println(letterCombinations(digits2));
    }
}
