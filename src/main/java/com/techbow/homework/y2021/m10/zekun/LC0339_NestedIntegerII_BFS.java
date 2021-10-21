package com.techbow.homework.y2021.m10.zekun;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0339_NestedIntegerII_BFS {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //cc
        if(nestedList == null || nestedList.get(0) == null) return -1;

        Queue<NestedInteger> queue = new LinkedList<>();
        loadNestedList(queue, nestedList);
        int res = 0;
        int valSum = 0;
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                NestedInteger cur = queue.poll();
                if(cur.isInteger()){
                    valSum += cur.getInteger() * level;
                }else{
                    for(NestedInteger nx : cur.getList()){
                        queue.offer(nx);
                    }
                }
            }
            res += valSum;//精髓在这：每次垫高一层，就相当于把已有的sum再加一遍！算法加强April.6:1:50:00;
        }
        return res;
    }

    private void loadNestedList(Queue<NestedInteger> que, List<NestedInteger> nt){
        for(NestedInteger next : nt){
            que.offer(next);
        }
    }
}
