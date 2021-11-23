package com.techbow.homework.y2021.m11.shengyuan;

public class LC_796 {
    public boolean rotateString(String str, String goal) {
        //cc
        if (str == null || goal == null) {
            return false;
        }
        if (str.length() != goal.length()) {
            return false;
        }
        if (str.length() == 0 && goal.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (ifRotate(str, goal, i)) {
                return true;
            }
        }
        return false;
    }
    private boolean ifRotate(String str, String goal, int shift) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt((i + shift) % str.length()) != goal.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean rotateString2(String str, String goal) {
        return (str.length() == goal.length() && ((str + str).contains(goal)));
    }
    public static void main(String[] args) {
        LC_796 test = new LC_796();
        String str = "abcde";
        String goal = "cdeab";
        boolean result = test.rotateString(str, goal);
        System.out.println(result);
    }
}
