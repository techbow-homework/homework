<<<<<<< HEAD:src/main/java/com/techbow/homework/y2021/m09/boyuan/小宋小宋/BFS_78.java
package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class BFS_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;

    }
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
=======
package com.techbow.homework.y2021.m09.xiaosongxiaosong;

import java.util.ArrayList;
import java.util.List;

public class BFS_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;

    }
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
>>>>>>> a1e7104c76f408e735a7c87017ab95e8de29924f:src/main/java/com/techbow/homework/y2021/m09/xiaosongxiaosong/BFS_78.java
