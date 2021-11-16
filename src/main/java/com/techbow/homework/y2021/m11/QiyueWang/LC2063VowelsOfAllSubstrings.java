package com.techbow.homework.y2021.m11.QiyueWang;

public class LC2063VowelsOfAllSubstrings {
    public static long countVowels(String word) {
        int n = word.length();
        long[] sumOfSubstrings = new long[n]; // all substrings containing char word[i]
        for(int i = 0; i < n; i++){
            if( i == 0){
                sumOfSubstrings[0] = n;
            }else{
                sumOfSubstrings[i] = n - i + sumOfSubstrings[i - 1] - i; // number of substrings containing word[i] starting at i + the count of the prev char - substrings containing previous char only.
            }
        }
        long res = 0;
        for(int i = 0; i < n; i++){
            char cur = word.charAt(i);
            if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u'){
                res += sumOfSubstrings[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String word = "aba";
        String word2 = "abc";
        String word3 = "noosabasboosa";
        System.out.println(countVowels(word));// 6
        System.out.println(countVowels(word2)); //3
        System.out.println(countVowels(word3)); //237
    }
}
