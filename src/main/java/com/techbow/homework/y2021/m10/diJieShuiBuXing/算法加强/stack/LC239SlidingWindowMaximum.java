package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;


import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 *
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 *
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */

//一个降序排列的deque
// queue 放的是indexes，而且清理的时候，会删掉所有<将要进来的这个元素的indexes，所以queue的size不是固定的，但是最大是k
//根据上步骤的清理queue的原理，queue里的第一个元素，总是最大的
public class LC239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }

        Deque<Integer> queue = new LinkedList();
        int[] res = new int[nums.length - k + 1];

        for(int i = 0 ; i < nums.length; i++){
            //当这个queue的第一个index（此时它的值是window的max，根据clean queue的方法来说），刚好是sliding window里左边要排出去的index的时候，就要弹出
            if(!queue.isEmpty() && queue.getFirst() == i - k){ //i-k，[i-k+1,i] 闭闭区间
                queue.pollFirst();
            }

            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);

            if(i >= k -1){ //第一次k size的window形成
                res[i-k+1] = queue.getFirst();
            }
        }
        return res;
    }

}
