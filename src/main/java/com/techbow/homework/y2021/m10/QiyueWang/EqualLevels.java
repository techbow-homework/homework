package com.techbow.homework.y2021.m10.QiyueWang;

// a record is maintained for the max simultaneous frequency seen so far. Each time a higher simultaneous frequency is noted, their variable is updated to the higher one.
// find the number of updates

// signal1 {1,2,3,3,3,5,4}
// signal2 {1,2,3,4,3,5,4}
// answer = 4, (updated at 1,2,3,5)
public class EqualLevels {
    public static int numOfUpdates(int[] s1, int[] s2){
        int n = s1.length >= s2.length ? s2.length : s1.length;
        int curMax = -1;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s1[i] == s2[i] && s1[i] > curMax){
                curMax = s1[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] s1 = new int[] {1,2,3,3,3,5,4};
        int[] s2 = new int[] {1,2,3,4,3,5,4};
        System.out.println(numOfUpdates(s1, s2)); // 4
    }
}
