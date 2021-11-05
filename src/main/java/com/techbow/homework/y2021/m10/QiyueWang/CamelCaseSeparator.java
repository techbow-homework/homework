package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.HashSet;

// check if words contains all words written in camelcase in variableName
public class CamelCaseSeparator {
    public static boolean isValid(String[] words, String variableName){
        int n = variableName.length();
        HashSet<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        for(int i = 0; i < n; i++){
            char c = variableName.charAt(i);
            StringBuilder cur = new StringBuilder();
            if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
                //System.out.println(c);
                cur.append(c);
                i++;
            }
            int j = i;
            while(j < n && Character.isLowerCase(variableName.charAt(j)) ){
                cur.append(variableName.charAt(j));
                j++;
            }
            if(j != i) i = j - 1;
            //System.out.println(cur.toString());
            if(cur.length() != 0 && !set.contains(cur.toString())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"is", "right", "valid"};
        String variableName = "isValid";
        String variableName2 = "IsValid";
        String variableName3 = "isValId";
        System.out.println(isValid(words,variableName));//t
        System.out.println(isValid(words,variableName2));//t
        System.out.println(isValid(words,variableName3));//f
    }
}
