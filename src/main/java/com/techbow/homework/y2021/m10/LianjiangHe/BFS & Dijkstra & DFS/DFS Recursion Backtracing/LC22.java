/*
        Instead of adding '(' or ')' every time as in Approach 1,
        let's only add them when we know it will remain a valid sequence.
        We can do this by keeping track of the number of opening and closing brackets we have placed so far.
        We can start an opening bracket if we still have one (of n) left to place.
        And we can start a closing bracket if it would not exceed the number of opening brackets.
*/
//选择用什么括号的时候,画下来其实是个树,然后是全遍历情况,所以用DFS

//接着走流程:①怎么选择;②怎么recursion;③怎么回溯

/*
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
* */
/*
整个全遍历的过程
"((()))"((回退一个)因为左括号不满3个所以加1个(因为右括号不满3个所以加两个))
* */
class Solution {
    public List<String> generateParenthesis(int n) {
        //初始化 new一个ArrayList名为res来存储结果
        List<String> res = new ArrayList();
        //new一个StringBuilder来存储括号(i.e路径)
        //初始的左括号数量为0,右括号数量也为0,当前需要完成的括号成对数n
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    //输出结果res 当前路径 cur 左括号数量open 右括号数量close 当前需要完成的括号成对数max
    public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max){
        //终止条件 如果路径的括号数量等于最大n数量的两倍,即所有括号都出现
        if (cur.length() == max * 2) {
            //将所有的括号,即路径添加到结果里去
            res.add(cur.toString());
            return;
        }
        //如果左括号的数量少于总数,先添加一个左括号,然后全遍历,最后回溯删除当前的括号回去
        if (open < max) {
            cur.append("(");
            backtrack(res, cur, open+1, close, max);//改变了左括号的数量,所以左括号+1
            cur.deleteCharAt(cur.length() - 1);
        }
        //如果右括号少于左括号,那么先添加一个右括号,然后全遍历探索所有右括号的可能性,最后回溯删掉当前的括号回去
        if (close < open) {
            cur.append(")");
            backtrack(res, cur, open, close+1, max);//改变了右括号的数量,所以右括号+1
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}