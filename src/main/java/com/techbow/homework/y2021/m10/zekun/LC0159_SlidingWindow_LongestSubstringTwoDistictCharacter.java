package com.techbow.homework.y2021.m10.zekun;

public class LC0159_SlidingWindow_LongestSubstringTwoDistictCharacter {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //cc
        if(s == null) return 0;
        char ch1 = '\0';
        char ch2 = '\0';
        int index1 = -1;//last seen index of char1
        int index2 = -1;//last seen index of char2
        int left = 0;
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(ch == ch1){
                index1 = right;
            }else if(ch == ch2){
                index2 = right;
            }else{
                if(index1 < index2){//remove ch1
                    ch1 = ch;//因为新来的char跟ch1 和ch2都不等，所以把新的char赋给index在前的index1；
                    left = index1 + 1;//把left更新为较小的index1 右边一位；
                    index1 = right;//
                }else{//remove ch2
                    ch2 = ch;
                    left = index2 + 1;
                    index2 = right;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
