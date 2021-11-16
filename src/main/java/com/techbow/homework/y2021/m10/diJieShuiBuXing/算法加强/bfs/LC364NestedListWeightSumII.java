package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.bfs;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//339 follow up
//brute forth:先dfs找max depth，再bfs 做，扫两遍，所以O2n n是tree的size
//实际是每层的depth计数是从leaf到root的层数，每往下增加一层 就是把之前上面的那些层数的depth都+1，实际上就是每往下一层，就把当前位置之前的所有层都deph+1，总和为所有之前走过的层的sum。
//所以res实际上是对于当前层，都要把之前每层到当前层的sum加到res里
public class LC364NestedListWeightSumII {


    public int depthSum_bfs(List<NestedInteger> nestedList) {
        //cc
        Queue<NestedInteger> queue = new LinkedList<>();
        int depth = 0;//TODO
        for(NestedInteger next:nestedList){
            queue.offer(next);
        }
        int res = 0;
        int valTillNow = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-->0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()){
                    valTillNow += cur.getInteger();
                }else{
                    for(NestedInteger next:cur.getList()){
                        queue.offer(next);
                    }
                }
            }
            depth++;
            res += valTillNow;
        }
        return res;
    }
}
