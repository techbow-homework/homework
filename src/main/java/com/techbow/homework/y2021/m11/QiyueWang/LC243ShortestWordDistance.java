package com.techbow.homework.y2021.m11.QiyueWang;
//Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

//    Example 1:
//
//    Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
//    Output: 3
//    Example 2:
//
//    Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
//    Output: 1
public class LC243ShortestWordDistance {
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int res = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;
        for(int i = 0; i < n;i ++){
            if(wordsDict[i].equals(word1)){
                i1 = i;
            }
            if(wordsDict[i].equals(word2)){
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(wordsDict, "practice","coding"));//3
        System.out.println(shortestDistance(wordsDict, "makes","coding"));//1
    }
}
