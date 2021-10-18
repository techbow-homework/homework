package com.techbow.homework.y2021.m10.zekun;

public class LC0424_TwoPointerSlidingWindow_LongestRepeatingChar {
    public int characterReplacement(String s, int k) {
        //cc
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[26];
        int start = 0;
        int maxLen = 0;//the maximum unique character window length
        char charMax = '\0';//most frequent char
        for(int end = 0; end < s.length(); end++){//end start from 0 to s.len
            char ch = s.charAt(end);
            count[ch - 'A']++;//count[] uses index as position of char, and value at index is the frequency of taht char in the array

            if(charMax == '\0' || count[ch - 'A'] > count[charMax - 'A']){
                charMax = ch;
            }//update most frequent char as end++;

            while(end - start + 1 - count[charMax - 'A'] > k){//if k is not enough to replace other chars than charMax in current window
                char chStart = s.charAt(start++); //start++ → move start to decrease window size
                count[chStart - 'A']--; //also consistent in count[] array
                if(chStart == charMax){ //here chStart is the first char of the new window, if it’s the same as the charMax of previous window, need to check if charStart of new window size is still the charMax of the new window size;
                    for(int i = 0; i < 26; i++){//go to count array to check if charMax will change due to reduced window size;
                        if(count[i] > count[charMax - 'A']){

                            charMax = (char)('A' + i);
                        }
                    }
                }
            }

            maxLen = Math.max(end - start + 1, maxLen);//update maxLen
        }
        return maxLen;
    }

}
