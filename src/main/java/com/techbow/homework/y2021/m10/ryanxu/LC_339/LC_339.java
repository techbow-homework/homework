package com.techbow.homework.y2021.m10.ryanxu.LC_339;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_339 {

    private static class NestedInteger {

        private int value;
        // Constructor initializes an empty nested list.
        public NestedInteger() {};

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 1;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            return;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            return;
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }

    public int depthSum(List<NestedInteger> nestedList) {

        if (nestedList == null) {
            return 0;
        }

        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int res = 0;
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    res += (cur.getInteger() * depth);
                } else {
                    for (NestedInteger nestedInteger : cur.getList()) {
                        queue.add(nestedInteger);
                    }
                }
            }
            depth++;
        }

        return res;
    }
}
