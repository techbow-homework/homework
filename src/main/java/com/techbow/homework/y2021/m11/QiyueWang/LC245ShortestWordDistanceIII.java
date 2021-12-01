package com.techbow.homework.y2021.m11.QiyueWang;

public class LC245ShortestWordDistanceIII {
    public static int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int min = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            int prev = -1;
            for(int i = 0; i < n; i++){
                if(word1.equals(wordsDict[i])){
                    if(prev == -1){
                        prev = i;
                    }else{
                        int dis = i - prev;
                        min = Math.min(min, dis);
                        prev = i;
                    }
                }
            }
        }else{
            int i1 = -1;
            int i2 = -1;
            for(int i = 0; i < n; i++){
                if(word1.equals(wordsDict[i])){
                    if(i2 != -1){
                        min = Math.min(min, i - i2);
                    }
                    i1 = i;
                }
                if(word2.equals(wordsDict[i])){
                    if(i1 != -1){
                        min = Math.min(min, i - i1);
                    }
                    i2 = i;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestWordDistance(wordsDict, "practice","coding"));//3
        System.out.println(shortestWordDistance(wordsDict, "makes","makes"));//3
    }
}
