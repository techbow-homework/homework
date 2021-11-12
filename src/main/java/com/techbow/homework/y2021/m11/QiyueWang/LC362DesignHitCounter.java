package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

public class LC362DesignHitCounter {
    private int size;
    private Deque<int[]> q; // time and count
    private final static int WINDOW = 300;
    public LC362DesignHitCounter() {
        q = new LinkedList<>();
        size = 0;
    }

    public void hit(int timestamp) {
        //int earlyTime = q.peek();
        while(!q.isEmpty() && q.peek()[0] <= timestamp - WINDOW){
            int count = q.poll()[1];
            size -= count;
        }
        if(q.isEmpty() || !q.isEmpty() && q.peekLast()[0] != timestamp){// a new time
            q.offer(new int[]{timestamp, 1});
            size += 1;
        }else if(!q.isEmpty()){ // hit at the same time
            int count = q.peekLast()[1];
            q.pollLast();
            q.offerLast(new int[]{timestamp, count + 1});
            size += 1;
        }
        //System.out.println(size);
    }

    public int getHits(int timestamp) {
        while(!q.isEmpty() && q.peek()[0] <= timestamp - WINDOW){
            int count = q.poll()[1];
            size -= count;
        }
        return size;
    }

    public static void main(String[] args) {
        LC362DesignHitCounter obj = new LC362DesignHitCounter();
        obj.hit(1);
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        obj.hit(4);
        obj.hit(300);
        System.out.println(obj.getHits(300));//6
        System.out.println(obj.getHits(301));//4
    }
}

