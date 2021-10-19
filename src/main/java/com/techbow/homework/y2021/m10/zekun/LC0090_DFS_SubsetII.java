package LC;
import java.util.*;
public class LC0090_DFS_SubsetII {
    public static void main(String[] args){
        LC0090_DFS_SubsetII sol = new LC0090_DFS_SubsetII();
        int[] input = {1, 2, 2};
        List<List<Integer>> output = sol.subsetsWithDup(input);
        System.out.println(output);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> nb = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(nums, res, 0, nb, used);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, int index, List<Integer> nb,  boolean[] used){
        int numLen = nums.length;
        //success base case
        if(index > numLen) return;
        List<Integer> copy = new ArrayList<>(nb);
        res.add(copy);

        //fail base case : NA
        // visited? no
        //recursion body
        for(int i = index; i < numLen; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){//这题的精髓！
                continue;
            }

            nb.add(nums[i]);
            used[i] = true;
            int nbsize = nb.size();
            dfs(nums, res, i + 1, nb, used);
            nb.remove(nbsize - 1);
            used[i] = false;
        }

    }
}
