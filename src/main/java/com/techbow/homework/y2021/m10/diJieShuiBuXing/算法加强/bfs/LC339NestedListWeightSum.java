package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.

Return the sum of each integer in nestedList multiplied by its depth.



Example 1:


Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
Example 3:

Input: nestedList = [0]
Output: 0


Constraints:

1 <= nestedList.length <= 50
The values of the integers in the nested list is in the range [-100, 100].
The maximum depth of any integer is less than or equal to 50.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//把它想成一个🌲，leaf node就是int值，不是int的就不是leaf，一直往下找到leaf为止，可以bfs，也可以dfs
public class LC339NestedListWeightSum {

    public int depthSum_bfs(List<NestedInteger> nestedList) {
         //cc
        Queue<NestedInteger> queue = new LinkedList<>();
        int depth = 0;//TODO
        for(NestedInteger next:nestedList){
            queue.offer(next);
        }
        int res = 0;


        while(!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;
            while(size-->0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()){
                    levelSum += cur.getInteger();
                }else{
                    for(NestedInteger next:cur.getList()){
                        queue.offer(next);
                    }
                }
            }
            depth++;
            res += levelSum * depth;
        }
        return res;
    }



    public int depthSum_dfs(List<NestedInteger> nestedList) {
        return depthSum_dfs(nestedList,1);
    }

    private int depthSum_dfs(List<NestedInteger> nestedList, int depth) {
        int total = 0;

        for(NestedInteger nested:nestedList){
            if(nested.isInteger()){
                total += nested.getInteger() * depth;
            }else{
                total += depthSum_dfs(nested.getList(),depth+1);
            }
        }
        return total;
    }
}
