package com.techbow.homework.y2021.m10.zekun;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0339_NestedInteger_BFS {
    public int depthSum(List<NestedInteger> nestedList) {
        //cc
        if(nestedList == null || nestedList.get(0) == null) return 0;

        Queue<NestedInteger> queue = new LinkedList<>();
        loadNestedList(queue, nestedList);
        int depth = 0;
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size(); //是否需要size？要看是否区别层与层；
            int levelSum = 0;
            for(int i = 0; i < size; i++){
                NestedInteger cur = queue.poll();
                if(cur.isInteger()){
                    levelSum += cur.getInteger();
                }else{
                    for(NestedInteger nx : cur.getList()){
                        queue.offer(nx);

                    }
                }
            }
            depth += level * levelSum;
            level++;
        }
        return depth;

    }

    private void loadNestedList(Queue<NestedInteger> que, List<NestedInteger> nt){
        for(NestedInteger nest : nt){
            que.offer(nest);
        }
    }
}
