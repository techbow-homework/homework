package com.techbow.homework.y2021.m09.cma;

public class LC364 {
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
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> myqueue = new LinkedList<>();
        int valueSum = 0;
        int res = 0;

        for(NestedInteger myitem: nestedList){
            myqueue.offer(myitem);
        }

        while(!myqueue.isEmpty()){
            int size = myqueue.size();
            while(size -- > 0){
                NestedInteger curr = myqueue.poll();
                if(curr.isInteger()){
                    valueSum += curr.getInteger();
                } else{
                    for(NestedInteger mynext:curr.getList()){
                        myqueue.offer(mynext);
                    }
                }
            }
            res += valueSum;
        }
        return res;
    }

}
