
package com.techbow.homework.y2021.m10.yidan;

import java.util.*;

/**
 * 253. Meeting Rooms II
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 *
 *Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 *
 */


/**
 * 253. Meeting Rooms II
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 *
 *Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 *
 */

/**
 *
 * Heap:通过int[]来实现，root(i), left(2i + 1), right(2i + 2)
 *
 * 逻辑结构是树，所以insert an element/node 是worst case normotize 后是log(n) n 为array的length
 *
 * 1. check corner case
 * 2. 分析：返回最小会议室个数，如果下一场会议的start time < 上一场会议的end time，则两场会议可以使用一个room；如果下一场会议start time > 下一场会议的end time，则需要新开一个room；如果下一场会议 end time < 上一场会议的start time，同样需要比较。
 * 3. 为了把程序简单化，我们可以将intervals[]的start time进行排序，这样确保下一场开始时间是>=上一场的开始时间的，所以只需要比较end time 和start time
 * 4. 我们可以通过一个minheap，记录会议们的结束时间，我们可以把minHeap看作tree，root 一定是小于他的左右child的，所以我们可以得到一个从最先结束到最后结束，有序的heap
 * 5. 当我们go through intervals时，如果需要新的room，把它加入heap 中；如果不需要，可以先把之前那个拿出来，再把新的加进去
 * 6. 最后minheap的size 就是我们要的个数
 *
 *
 */

public class LC_253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

        queue.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek() ) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }

}
