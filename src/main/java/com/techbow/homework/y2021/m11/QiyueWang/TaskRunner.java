package com.techbow.homework.y2021.m11.QiyueWang;
// return the sequence of tasks' indices based on start time s, duration d, priority p.
// if can be run, highest p first, then earliest s, lowest d, lowest index.

import java.util.*;

public class TaskRunner {
    public static List<Integer> sequence(int[] s, int[] d, int[] p){
        int n = s.length;
        List<Integer> res = new ArrayList<>();
        Queue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                if(l1.get(0) == l2.get(0)){
                    if(l1.get(1) == l2.get(1)){
                        if(l1.get(2) == l2.get(2)){
                            return l1.get(3) - l2.get(3);
                        }else{
                            return l1.get(2) - l2.get(2);
                        }
                    }else{
                        return l1.get(1) - l2.get(1);
                    }
                }else{
                    return l1.get(0) - l2.get(0);
                }
            }
        });

        List[] pairs = new List[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new ArrayList<Integer>();
            pairs[i].add(-p[i]);// large priority first
            pairs[i].add(s[i]);
            pairs[i].add(d[i]);
            pairs[i].add(i);

        }
        int time = 0;
        int i = 0;
        while(!pq.isEmpty() || i < n){
            if(pq.isEmpty()){
                time = Math.max(time, s[i]);
            }
            while(i < n && s[i] <= time){
                pq.offer(pairs[i]);
                i++;
            }
            List<Integer> cur = pq.poll();
            res.add(cur.get(3));//index
            time += cur.get(2);//duration
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = new int[]{0,2,2};
        int[] d = new int[]{1,1,1};
        int[] p = new int[]{0,0,1};
        System.out.println(sequence(s,d,p));// 0, 2, 1
        int[] s1 = new int[]{0,1,2,2};
        int[] d1 = new int[]{2,1,1,1};
        int[] p1 = new int[]{0,0,2,0};
        System.out.println(sequence(s1,d1,p1));// 0, 2, 1, 3
    }
}
