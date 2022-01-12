/*
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        for (int k = 0; k < n + 1; ++k) {
            DFS(0, new ArrayList<Integer>(), output, nums, n, k);
        }
        return output;
    }
    public void DFS(int first,
                    ArrayList<Integer> curr,
                    List<List<Integer>> output,
                    int[] nums,
                    int n,
                    int k){
        //终结条件
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            DFS(i + 1, curr, output, nums, n, k);
            // 回溯
            curr.remove(curr.size() - 1);
        }
    }
}