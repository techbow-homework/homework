package com.techbow.homework.y2021.m09.QiyueWang;

public class LC423ReconstructOriginalDigitsFromEnglish {
    public static String originalDigits(String s) {
        int n = s.length();
        char[] bucket = new char[26];
        int[] res = new int[10];
        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);
            bucket[cur - 'a']++;
        }
        // start from  z w u x g  in  0 2 4 6 8
        res[0] = bucket['z' - 'a'];
        res[2] = bucket['w' - 'a'];
        res[4] = bucket['u' - 'a'];
        res[6] = bucket['x' - 'a'];
        res[8] = bucket['g' - 'a'];
        // then f h s in 3 5 7
        res[3] = bucket['h' - 'a'] - res[8];
        res[5] = bucket['f' - 'a'] - res[4];
        res[7] = bucket['s' - 'a'] - res[6];
        // then o i in 1 9
        res[1] = bucket['o' - 'a'] - res[0] - res[2] - res[4];
        res[9] = bucket['i' - 'a'] - res[5] - res[6] - res[8];

        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < res[i]; j++){
                ret.append(i);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s1 = "owoztneoer";
        String s2 = "fviefuro";
        System.out.println(originalDigits(s1)); // "012"
        System.out.println(originalDigits(s2)); // "45"
    }
}
