package com.techbow.homework.y2021.m03.Taiyi;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC253 {
    public int minMeetingRooms(int[][] intervals) {
        Queue<TimePoint> timeOrder = new PriorityQueue<>((a, b)->{if (a.time != b.time) return a.time - b.time;
        else if (a.isStart == false) return - 1;
        else return 1;});
        for (int[] point : intervals){
            timeOrder.offer(new TimePoint(point[0], true));
            timeOrder.offer(new TimePoint(point[1], false));
        }
        int room = 0;
        int max = 0;
        while (!timeOrder.isEmpty()){
            TimePoint cur = timeOrder.poll();
            if (cur.isStart) {
                room++;
                max = Math.max(max, room);
            }else room--;
        }
        return max;

    }
}
class TimePoint{
    int time;
    boolean isStart;
    public TimePoint(int time, boolean isStart){
        this.time = time;
        this.isStart = isStart;
    }
}
