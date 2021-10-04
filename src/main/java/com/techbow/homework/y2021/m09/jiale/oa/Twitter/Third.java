package com.techbow.homework.y2021.m09.jiale.oa.Twitter;

class Third {

    /*
     * Complete the 'getLargestString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String getLargestString(String s, int k) {
        // Write your code here
        int n = s.length();
        int[] charset = new int[26];
        for (int i = 0; i < n; i++) {
            charset[s.charAt(i)-'a']++;
        }
        StringBuilder newString = new StringBuilder(n);
        for (int i = 25; i >=0; i--) {
            int count = 0;
            while(charset[i] > 0) {
                newString.append((char)(i + 'a'));
                charset[i]--;
                count++;
                if (charset[i] > 0 && count == k) {
                    Character next = nextAvailableChar(charset, i);
                    if (next == null) {
                        return newString.toString();
                    }
                    newString.append(next);
                    count = 0;
                }
            }
        }
        return newString.toString();
    }

    private static Character nextAvailableChar(int[] charset, int start) {
        for (int i = start - 1; i >= 0; i--) {
            if (charset[i] > 0) {
                charset[i]--;
                return (char)(i+'a');
            }
        }
        return null;
    }

}
