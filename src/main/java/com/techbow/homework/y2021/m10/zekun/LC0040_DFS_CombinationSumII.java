package LC;
import java.util.*;

public class LC0040_DFS_CombinationSumII {
    public static void main(String[] args){
        LC0040_DFS_CombinationSumII obj = new LC0040_DFS_CombinationSumII();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> sol = obj.combinationSum2(candidates, target);
        System.out.println(sol);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if(target == 0 || candidates.length == 0) return res;

        List<Integer> nb = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(target, candidates, 0, 0, nb, res, used);

        return res;

    }

    private void dfs(int target, int[] candidates, int index, int sum, List<Integer> nb, List<List<Integer>> res, boolean[] used){
        int canLen = candidates.length;
        //success case
        if(sum == target){
            List<Integer> copy = new ArrayList<>(nb);
            res.add(copy);
            return;
        }

        //fail case
        if(index >= canLen || sum > target){
            return;
        }

        //check visited: needed

        //recursion body
        for(int i = index; i < canLen; i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){//这题的精髓！
                continue;
            }
            nb.add(candidates[i]);
            sum = sum + candidates[i];
            used[i] = true;
            dfs(target, candidates, i + 1, sum, nb, res, used); //
            nb.remove(nb.size() - 1);
            sum = sum - candidates[i];
            used[i] = false;
        }
    }
}
