package com.techbow.homework.y2021.m10.kuixiaosu;

public class SubsetsS1 {
    private void dfs(char[] array, int index, StringBuilder sb, List<String> res) {
        res.add(sb.toString());
//无脑加答案，如果有base case应该放在这一行的后面，for loop进不去就相当于有base case。如果只写res.add(sb)，加进去的是几个一模一样的地址，dereference以后就是一模一样的string。必须做deep copy， create a new object把当时当刻string的情形保存在不同的地址里
        for (int i = index; i < array.length; i++) {
            sb.append(array[i]);
            dfs(array, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1); //backtracing，和sb.append是成对出现的。sting和sb都用array实现，删除最后一个位置的值是O（1）时间复杂度
        }
    }
}
