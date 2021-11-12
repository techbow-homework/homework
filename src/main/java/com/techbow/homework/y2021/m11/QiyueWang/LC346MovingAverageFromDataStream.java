package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.LinkedList;
import java.util.Queue;

public class LC346MovingAverageFromDataStream {
    private Queue<Integer> q;
    private int sum;
    private int size;
    public LC346MovingAverageFromDataStream(int size) {
        q = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if(q.size() >= this.size){
            int num = q.poll();
            sum -= num;
        }
        q.offer(val);
        sum += val;
        return sum / (q.size() * 1.0);
    }

    public static void main(String[] args) {
        LC346MovingAverageFromDataStream obj = new LC346MovingAverageFromDataStream(3);
        System.out.println(obj.next(1));//1
        System.out.println(obj.next(10));//5.5
        System.out.println(obj.next(3));//4.66667
        System.out.println(obj.next(5));//6.0

    }
}
