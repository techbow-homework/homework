package com.techbow.homework.y2021.m09.cma;

import java.util.LinkedList;

public class LC339 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> myqueue = new LinkedList<>();
        int res = 0;
        int minLen = 1;
        for(NestedInteger myitem : nestedList){
            myqueue.offer(myitem);
        }
        while(!myqueue.isEmpty()){
            int size = myqueue.size();
            int levelSum = 0;
            while(size -- > 0){
                NestedInteger curr = myqueue.poll();
                if(curr.isInteger()){
                    levelSum += curr.getInteger();
                } else{
                    for(NestedInteger myitem: curr.getList()){
                        myqueue.offer(myitem);
                    }
                }
            }
            res += levelSum*minLen++;
        }
        return res;
    }


}
