/*
方法头给了一个array作为候选,一个target作为要求和的结果,本质上还是遍历所有可能性的树
所以采用DFS,因为可以重复利用候选[]中的值,所以不用标记是否用过了
* */


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        DFS(candidates, res, comb, target, 0);
        return res;
    }
    private void DFS(
            int[] candidates,
            List<List<Integer>> res,
            LinkedList<Integer> comb,//路径组合
            int remain,//剩余数值
            int start){//起始candidate[]的index
    //终止条件如果剩余数值为0
    if (remain == 0) {
    //new 一个ArrayList存放现在路径combination的组合,把结果加入到res里去
    res.add(new ArrayList<Integer>(comb));
    return;
    } else if (remain < 0) {
    //如果最后总和超了,直接return
    return;
    }
    for (int i = start; i < candidates.length; ++i) {
    comb.add(candidates[i]);
    DFS(candidates, res, comb, remain - candidates[i], i);//变动了remain的值
    //回溯,删掉最后一个值
    comb.removeLast();
        }
    }
}
