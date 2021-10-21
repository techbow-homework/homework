package com.techbow.homework.y2021.m10.qiangzhai;

public class L268_MissingNumber {
    public int missingNumber(int[] nums) {
        //create hashset
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }
        //looping hashset
        int counter = nums.length + 1;
        for (int i = 0; i <= counter; i++) {
            if (numset.contains(i) == false) {
                return i;
            }
        }
        return -1;
    }

//more solutions to be added
}
