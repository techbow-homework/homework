package com.techbow.homework.y2021.m11.QiyueWang;

public class LC65ValidNumber {
    public static boolean isNumber(String s) {
        boolean hasDigit = false;
        boolean hasExp = false;
        boolean hasDot = false;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(hasDigit){
                if(Character.isDigit(cur)) continue;
                else if(cur == '-' || cur == '+'){
                    if((s.charAt(i - 1) == 'E' || s.charAt(i - 1) == 'e') && i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    }else{
                        return false;
                    }
                }else if(cur == 'e' || cur == 'E'){
                    if(hasExp || i == s.length() - 1) return false;
                    hasExp = true;
                }else if(cur == '.'){
                    if(hasExp || hasDot) return false;
                    hasDot = true;
                }else{
                    return false;
                }
            }else{
                if(Character.isDigit(cur)){
                    hasDigit = true;
                }else if(cur == '+' || cur =='-'){
                    if(hasDot || i!= 0) return false;
                }else if(cur == '.'){
                    if(hasDot || i == s.length() - 1) return false;
                    hasDot = true;
                }else{
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String[] tArr = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] fArr = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", ".", "..", "+.", ".+", ".e", ".e-"};
        for(String s : tArr){
            if(!isNumber(s)){
                System.out.println("error with true nums");
            }
        }
        for(String s : fArr){
            if(isNumber(s)){
                System.out.println("error with false nums");
            }
        }
        System.out.println("good if no error message");
    }
}
// time O(n) space O(1)
