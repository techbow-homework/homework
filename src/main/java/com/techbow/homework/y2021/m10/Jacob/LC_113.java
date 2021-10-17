public void dfs(TreeNode root, int sum, int toal, List<Integer> list,
        List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
        return;
        //把当前节点值加入到list中
        list.add(new Integer(root.val));
        //没往下走一步就要计算走过的路径和
        toal += root.val;
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null) {
        //如果到达叶子节点，并且sum等于toal，说明我们找到了一组，
        //要把它放到result中
        if (sum == toal)
        result.add(new ArrayList(list));
        //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
        //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
        //一个结点的值给remove掉。
        list.remove(list.size() - 1);
        //到叶子节点之后直接返回，因为在往下就走不动了
        return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找
        dfs(root.left, sum, toal, list, result);
        dfs(root.right, sum, toal, list, result);
        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        //我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
        }
