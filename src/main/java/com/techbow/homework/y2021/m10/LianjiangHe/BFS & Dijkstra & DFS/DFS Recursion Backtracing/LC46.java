//option 1 DFS
/*
递归公式 ①选择
        ②recursion
        ③回撤

分析思路:需要全排列
需要的参数 int depth,i.e 深度,随着一层一层每次选择选择一个数,
把选择的数加入到路径中,我们选择Stack or List来完成储存路径的操作,因为是Java自带的函数方法
有.add .push .append 来完成添加 .remove .pop .delete 等等来做回撤的操作,本题用Deque来实现Stack的功能
为了存储[1,2,3]之类的,所以准备用Deque<Integer> Path来存储路径
因为选择过的数字,例如选择完1后就不能选择1了,要选择剩下的数字了,所以准备用boolean[] used的Array来"标记"(存储)数字是否使用过
因为返回的结果res是List<List<Integer>>的类型(List包List),所以准备新建一个 List<List<Integer>>res 来存储结果
每当path的(长度,同时也是)层数也就depth是跟nums[]的长度nums.length=len一致的时候,就把path加入到res里,进行回溯了

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    public List<List<Integer>> permute(int[] nums) {

    }
}
//step 1 递归方法的参数
class Solution {
    public List<List<Integer>> permute(int[] nums) {

    }
    private void dfs(
    Deque<Integer> path,
    boolean[] used,
    int[] nums,
    List<List<Integer>> res,
    int depth,
    int len){

    }
}
//step 2 写DFS方法的终止条件,满足时用每次都new一个ArrayList来把path里的东西保存到res里,达到[1,2,3],[1,3,2]这样的效果
class Solution {
    public List<List<Integer>> permute(int[] nums) {

    }
    private void dfs(Deque<Integer> path,
    boolean[] used,
    int[] nums,
    List<List<Integer>> res,
    int depth,
    int len){
        if(depth == len){
        res.add(new ArrayList<>(path));
        return;
        }
    }
}
//step 3 当这个数没有使用的时候,每次从nums里选择一个数,添加到path里,加入后,更新这个数为被使用过的状态,然后进行recursion
         不一样的是depth + 1就可以往下面接着走,上面有判断条件,保证它走到不能走
class Solution {
    public List<List<Integer>> permute(int[] nums) {

    }
    private void dfs(Deque<Integer> path,
    boolean[] used,
    int[] nums,
    List<List<Integer>> res,
    int depth,
    int len){
        if(depth == len){
        res.add(new ArrayList<>(path));
        return;
        }

        for(int i = 0; i<len; i++){
            if(!used[i]){
            path.addLast(nums[i]);
            used[i] = true;
            dfs(path, used, nums, res, depth + 1, len);

            }
        }
    }
}
//step 4 回溯
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
    }
    private void dfs(Deque<Integer> path,
    boolean[] used,
    int[] nums,
    List<List<Integer>> res,
    int depth,
    int len){
        if(depth == len){
        res.add(new ArrayList<>(path));
        return;
        }

        for(int i = 0; i<len; i++){
            if(!used[i]){
            path.addLast(nums[i]);
            used[i] = true;
            dfs(path, used, nums, res, depth + 1, len);
            used[i] = false;//标记为false
            path.removeLast();//把path的最后一个数字删去,完成回溯
            }
        }
    }
}
//step 5 完成主函数,创建变量,初始化变量值
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if(len == 0){
        return res;
        }
        boolean[] used = new boolean[len];
        dfs(path, used, nums, res, 0, len);//int depth 初始depth为0;
        return res;
    }
    private void dfs(
    Deque<Integer> path,
    boolean[] used,
    int[] nums,
    List<List<Integer>> res,
    int depth,
    int len){
        if(depth == len){
        res.add(new ArrayList<>(path));
        return;
        }

        for(int i = 0; i<len; i++){
            if(!used[i]){
            path.addLast(nums[i]);
            used[i] = true;
            dfs(path, used, nums, res, depth + 1, len);
            used[i] = false;//标记为false
            path.removeLast();//把path的最后一个数字删去,完成回溯
            }
        }
    }
}

* */

//option 2
 class Solution {
    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        //一个终结条件，也就是满足条件的时候
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list //一个全局变量，用于保存所有集合
        List<List<Integer>> output = new LinkedList();
        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();

        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        //传入三(4)个参数，没有附加参数
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}