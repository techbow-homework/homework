package com.techbow.homework.y2021.m11.mengyu;

public class LC125 {
    /*
    public boolean isPalindrome(String s) {
        String cleaned = cleanString(s);
        return cleaned.equals(reverse(cleaned));
    }
    private String reverse (String s) {
        char[] sChar = s.toCharArray();
        int start = 0;
        int end = sChar.length - 1;
        while (start < end) {
            char temp = sChar[start];
            sChar[start++] = sChar[end];
            sChar[end--] = temp;
        }
        return new String(sChar);
    }
    private String cleanString(String s) {
        //amanaplanplan,
        //         s
        //              f
        char[] sChar = s.toLowerCase().trim().toCharArray();
        int slow = 0;
        for (int fast = 0; fast < sChar.length; fast++) {
            if ((sChar[fast] >= 'a' && sChar[fast] <= 'z') ||
                    (sChar[fast] >= '0' && sChar[fast] <= '9')) {
                sChar[slow++] = sChar[fast];
            }
        }
        return new String(sChar, 0, slow);
    }
    */
    //S2
    public boolean isPalindromeS2(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
