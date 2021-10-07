/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    private PriorityQueue<int[]> minHeap = 
        new PriorityQueue<>((a,b) -> Double.compare(
            b[0]*b[0] + b[1]*b[1],
            a[0]*a[0] + a[1]*a[1]
            ));
    public int[][] kClosest(int[][] points, int k) {
        for (int[] point : points) {
            minHeap.offer(point);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i=0; i<k; i++) {
            int[] point = new int[2];
            point[0] = minHeap.peek()[0];
            point[1] = minHeap.poll()[1];
            res[i] = point;
        }
        
        return res;
    }
}
// @lc code=end

