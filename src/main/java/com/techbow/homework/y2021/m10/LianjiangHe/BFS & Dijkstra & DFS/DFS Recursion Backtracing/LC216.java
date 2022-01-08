/*
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Input: k = 4, n = 1
Output: []
* */
//不重复的遍历树,没有标记,直接往后+1,使之不重复
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        DFS(n, k, comb, 0, res);
        return res;
    }
    public void DFS(int remain,
                    int k,
                    LinkedList<Integer> comb,
                    int next_start,
                    List<List<Integer>> res){
        if (remain == 0 && comb.size() == k) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }else if (remain < 0 || comb.size() == k) {
            return;
        }
        //回溯
        for (int i = next_start; i < 9; ++i) {
            comb.add(i + 1);
            DFS(remain - (i + 1), k, comb, i + 1, res);
            comb.removeLast();
        }
    }
}

//

