package com.techbow.homework.y2021.m10.ryanxu.LC_282;

import java.util.ArrayList;
import java.util.List;

public class LC_282 {
    public List<String> addOperators(String num, int target) {

        if (num == null) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(res, path, num, 0, target, 0, 0);

        return res;
    }

    private void dfs(List<String> res, StringBuilder path, String num, int idx, int target, long curSum, long lastNum) {

        int numLen = num.length();
        if (idx == num.length() && curSum == target) {
            res.add(path.toString());
            return;
        }

        if (idx >= numLen) {
            return;
        }

        for (int len = 1; len <= numLen - idx; len++) {
            long curNum = Long.valueOf(num.substring(idx, idx + len));
            int pathLen = path.length();

            if (pathLen == 0) {
                path.append(curNum);
                dfs(res, path, num, idx + len, target, curSum + curNum, curSum + curNum);
                path.setLength(pathLen);
            } else {
                // +
                path.append("+" + curNum);
                dfs(res, path, num, idx + len, target, curSum + curNum, curNum);
                path.setLength(pathLen);
                // -
                path.append("-" + curNum);
                dfs(res, path, num, idx + len, target, curSum - curNum, -curNum);
                path.setLength(pathLen);
                // *
                path.append("*" + curNum);
                dfs(res, path, num, idx + len, target, curSum - lastNum + lastNum * curNum, curNum * lastNum);
                path.setLength(pathLen);
            }
            if (curNum == 0) {
                break;
            }
        }

//        for (int i = idx; i < numLen; i++) {
//            long curNum = Long.valueOf(num.substring(idx, i + 1));
//            int pathLen = path.length();
//
//            if (pathLen == 0) {
//                path.append(curNum);
//                dfs(res, path, num, i + 1, target, curSum + curNum, curSum + curNum);
//                path.setLength(pathLen);
//            } else {
//                // +
//                path.append("+").append(curNum);
//                dfs(res, path, num, i + 1, target, curSum + curNum, curNum);
//                path.setLength(pathLen);
//                // -
//                path.append("-").append(curNum);
//                dfs(res, path, num, i + 1, target, curSum - curNum, -curNum);
//                path.setLength(pathLen);
//                // *
//                path.append("*").append(curNum);
//                dfs(res, path, num, i + 1, target, curSum - lastNum + lastNum * curNum, curNum * lastNum);
//                path.setLength(pathLen);
//            }
//            if (curNum == 0) {
//                break;
//            }
//        }
    }

    public static void main(String[] args) {
        LC_282 lc_282 = new LC_282();
//        System.out.println(lc_282.addOperators("123456789", 45).size());
//        List<String> res = lc_282.addOperators("123456789", 45);
//        List<String> expect = Arrays.asList("1*2*3*4*5-6-78+9","1*2*3*4+5+6-7+8+9","1*2*3+4+5+6+7+8+9","1*2*3+4+5-6*7+8*9","1*2*3+4-5*6+7*8+9","1*2*3+4-5*6-7+8*9","1*2*3-4*5+6*7+8+9","1*2*3-4*5-6+7*8+9","1*2*3-4*5-6-7+8*9","1*2*3-45+67+8+9","1*2*34+56-7-8*9","1*2*34-5+6-7-8-9","1*2+3*4-56+78+9","1*2+3+4+5*6+7+8-9","1*2+3+4-5+6*7+8-9","1*2+3+4-5-6+7*8-9","1*2+3+45+67-8*9","1*2+3-45+6+7+8*9","1*2+34+5-6-7+8+9","1*2+34+56-7*8+9","1*2+34-5+6+7-8+9","1*2+34-56+7*8+9","1*2+34-56-7+8*9","1*2-3*4+5+67-8-9","1*2-3+4-5-6*7+89","1*2-3-4*5+67+8-9","1*2-3-4+56-7-8+9","1*2-34+5*6+7*8-9","1*23+4*5-6+7-8+9","1*23-4-56-7+89","1+2*3*4*5+6+7-89","1+2*3*4+5*6+7-8-9","1+2*3*4-5+6*7-8-9","1+2*3+4*5*6+7-89","1+2*3+4*5-6+7+8+9","1+2*3-4-5-6*7+89","1+2*34-5*6+7+8-9","1+2+3*4*5+6-7-8-9","1+2+3*4+5+6*7-8-9","1+2+3*45-6-78-9","1+2+3+4+5+6+7+8+9","1+2+3+4+5-6*7+8*9","1+2+3+4-5*6+7*8+9","1+2+3+4-5*6-7+8*9","1+2+3-4*5+6*7+8+9","1+2+3-4*5-6+7*8+9","1+2+3-4*5-6-7+8*9","1+2+3-45+67+8+9","1+2-3*4*5+6+7+89","1+2-3*4+5*6+7+8+9","1+2-3*4-5+6*7+8+9","1+2-3*4-5-6+7*8+9","1+2-3*4-5-6-7+8*9","1+2-3+4*5+6*7-8-9","1+2-3+45+6-7-8+9","1+2-3+45-6+7+8-9","1+2-3-4-5*6+7+8*9","1+2-3-45-6+7+89","1+2-34+5+6+7*8+9","1+2-34+5+6-7+8*9","1+2-34-5-6+78+9","1+23*4+5-6-7*8+9","1+23*4-5-6*7+8-9","1+23*4-56+7-8+9","1+23+4+5+6+7+8-9","1+23+4-5*6+7*8-9","1+23+4-5-67+89","1+23-4*5+6*7+8-9","1+23-4*5-6+7*8-9","1+23-4-5+6+7+8+9","1+23-4-5-6*7+8*9","1+23-45+67+8-9","1-2*3*4+5-6+78-9","1-2*3*4-5-6+7+8*9","1-2*3+4*5+6+7+8+9","1-2*3+4*5-6*7+8*9","1-2*3+4+5+6*7+8-9","1-2*3+4+5-6+7*8-9","1-2*3+4+56+7-8-9","1-2*3+45-67+8*9","1-2*3-4+5*6+7+8+9","1-2*3-4-5+6*7+8+9","1-2*3-4-5-6+7*8+9","1-2*3-4-5-6-7+8*9","1-2*34+5*6-7+89","1-2+3*4*5-6-7+8-9","1-2+3+4-5*6+78-9","1-2+3+45+6-7+8-9","1-2+3-4*5-6+78-9","1-2+3-45+6-7+89","1-2-3*4+5+6+7*8-9","1-2-3*4-5-6+78-9","1-2-3+4-5+67-8-9","1-2-3+45-6-7+8+9","1-2-34+5+6+78-9","1-2-34+56+7+8+9","1-2-34-5+6+7+8*9","1-23*4+5+6*7+89","1-23+4*5-6*7+89","1-23+4-5+67-8+9","1-23+45-67+89","1-23-4+5+67+8-9","1-23-4-5-6-7+89","12*3*4-5*6-78+9","12*3+4+5+6-7-8+9","12*3+4+5-6+7+8-9","12*3-4-5-6+7+8+9","12*3-4-56+78-9","12+3*4+5+6-7+8+9","12+3*45-6-7-89","12+3+4-56-7+89","12+3-4*5+67-8-9","12+3-45+6+78-9","12+34-5-6-7+8+9","12-3*4*5+6+78+9","12-3*4-5+67-8-9","12-3+4*5+6-7+8+9","12-3+4+56-7-8-9","12-3-4+5*6-7+8+9","12-3-4-56+7+89","12-3-45-6+78+9");
//        HashSet<String> resSet = new HashSet<>(res);
//        for (String str : expect) {
//            resSet.remove(str);
//        }
//        System.out.println(resSet);
        System.out.println(lc_282.addOperators("3456237490", 9191));
    }
}
