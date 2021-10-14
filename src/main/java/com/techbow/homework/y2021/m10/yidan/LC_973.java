package com.techbow.homework.y2021.m10.yidan;

import java.util.PriorityQueue;

public class LC_973 {

    /*
1. calculate the distance and store to heap directly
2. keep the heap size = k
3. return heap result


*/

        public int[][] kClosest(int[][] points, int k) {
            //cc

            PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));

            for (int i = 0; i < k; i++) {
                heap.offer(new int[]{(int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)), i});
            }

            for (int i = k; i < points.length; i++) {
                int temp = (int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
                if (temp < heap.peek()[0]) {
                    heap.poll();
                    heap.offer(new int[]{temp, i});
                }
            }

            int[][] result = new int[k][2];
            for (int i = 0; i < k; i++) {
                result[i] = points[heap.poll()[1]];
            }
            return result;

        }

}
