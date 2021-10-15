package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;

import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 */

//需要保持一个升序的stack，这样当下一个element是降序时候，就是所有stack里比element低的height的max area，
//保持一个desc order的stack，heights里一旦有比top大的，就pop一直pop完
//stack里存的是index，是从那个位置，可以一直往右延伸到i的这些elements的index，都是按height升序排列的，因为中间出现的比height[i]大的，不能延伸到i的都被pop
//pop出来的时候计算面积,因为是升序的，只考虑pop出来这个元素的（左边元素的index ,i) 开开区间。长度是 i - 左边元素的index - 1
// 要做post processing， 当i等于heights长度的时候 设定value是0，这样栈里的元素都得pop出来
public class LC84LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length ==0){
            return 0;
        }

        Stack<Integer> descStack = new Stack<>();
        int maxArea = 0;
        for(int i = 0 ; i <= heights.length; i++){
            int h = i == heights.length ? 0 : heights[i];
            while (!descStack.isEmpty() && heights[descStack.peek()] > h) {
                int index = descStack.pop();
                int range = descStack.isEmpty() ? i : i - descStack.peek() -1;
                int area = heights[index] * range;
                maxArea = Math.max(maxArea,area);
            }
            descStack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1};
        largestRectangleArea(heights);
    }
}
