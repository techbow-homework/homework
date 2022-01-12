/*
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
//option 1
unsorted的candidates,用Sort后,然后+1避免重复
* */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        Arrays.sort(candidates);
        DFS(candidates, comb, target, 0, res);
        return res;
    }

    private void DFS(int[] candidates,
                     LinkedList<Integer> comb,
                     Integer remain,
                     Integer curr,//当前canditates的index
                     List<List<Integer>> results) {
        //终结条件
        if (remain == 0) {
            //Deep Copy
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        //选择加入条件,当前挑一个,往后加
        for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
                continue;
            //pick为下一个要加进来的值
            Integer pick = candidates[nextCurr];
            //如果加进来的值超过总量了
            if (remain - pick < 0)
                break;

            comb.addLast(pick);
            DFS(candidates, comb, remain - pick, nextCurr + 1, results);
            //回溯
            comb.removeLast();
        }
    }
}

// option 2
// 没有用Sort而是用HashMap配Counter来标记用过的val