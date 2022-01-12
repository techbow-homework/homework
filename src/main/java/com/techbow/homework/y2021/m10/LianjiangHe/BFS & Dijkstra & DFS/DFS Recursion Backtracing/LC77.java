/*
Input: n = 4, k = 2
Output:[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
* */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new LinkedList();
        DFS(1, new LinkedList<Integer>(), output, n, k);
        return output;
    }
    private void DFS(int first,
                     LinkedList<Integer> curr,
                     List<List<Integer>> output,
                     int n,
                     int k){//
        //终结条件
        if (curr.size() == k){
            output.add(new LinkedList(curr));
        }
        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            DFS(i + 1, curr, output, n, k);
            // 回溯
            curr.removeLast();
        }
    }
}
