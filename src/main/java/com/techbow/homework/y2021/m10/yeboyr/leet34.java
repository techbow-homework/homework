package com.techbow.homework.y2021.m10.yeboyr;

public class leet34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int firstOccurrence = this.findBound(nums, target, true);

            if (firstOccurrence == -1) {
                return new int[]{-1, -1};
            }

            int lastOccurrence = this.findBound(nums, target, false);

            return new int[]{firstOccurrence, lastOccurrence};
        }

        private int findBound(int[] nums, int target, boolean isFirst) {
            int N = nums.length;
            int begin = 0;
            int end = N - 1;

            while (begin <= end) {
                int mid = begin + (end - begin) / 2;

                if (nums[mid] == target) {
                    if (isFirst) {
                        if (mid == begin || nums[mid - 1] != target) {
                            return mid;
                        }

                        end = mid - 1;

                    } else {

                        if (mid == end || nums[mid + 1] != target) {
                            return mid;
                        }

                        begin = mid + 1;

                    }

                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {//if(nums[mid]<target)

                    begin = mid + 1;
                }
            }

            return -1;
        }
    }
}

/*
通过boolean控制第二个method的走向true/false来实现找到起点和终点的目的；
this是为了调用同一个对象的不同方法；
 */
