package com.techbow.homework.y2021.m03.Taiyi;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC295 {
    private Queue<Integer> minHeap ;
    private Queue<Integer> maxHeap;

    public LC295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);

    }

    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()){
            maxHeap.offer(num);

        }else{
            if (maxHeap.size() > minHeap.size()){
                if (num < maxHeap.peek()){
                    maxHeap.offer(num);
                    minHeap.offer(maxHeap.poll());
                }else{
                    minHeap.offer(num);
                }
            }else{
                if (num < maxHeap.peek()){
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                }
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
