/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] v1, int[] v2) {
                return v1[1] - v2[0];
            }
        });
        
        List<int []> res = new ArrayList<>();
        for (int[] i: intervals) {
            res.add(i);
        }
        
//      compare last to first
        for(int i=0; i<res.size()-1; i++) {
            // covering
            if (res.get(i)[1] >= res.get(i+1)[1]) {
                System.out.println("here");
                System.out.println(res.get(i+1)[0]);
                System.out.println(res.get(i+1)[1]);
                res.remove(res.get(i+1));
            }
            
            // overlapping + touching
            
            else if(res.get(i)[1] > res.get(i+1)[0]) {
                // merge it!
                res.get(i+1)[0] = res.get(i)[0];
                res.remove(res.get(i));
            }
        }
                    
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

