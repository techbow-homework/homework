package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        /*
        n = 1
        ()
        n = 2
        ()() (())
                {}
            (              )
      ((             ()
  (((     (()    ()(     ())
         */
        List<String> result = new ArrayList<>();
        dfsParenthesis(n, 0,0,new StringBuilder(),result);
        return result;
    }
    private void dfsParenthesis(int n, int openParentheses, int closeParentheses, StringBuilder sb, List<String> result) {
        if (openParentheses + closeParentheses == 2*n) {
            result.add(sb.toString()); //deep copy
            return;
        }
        if (openParentheses < n) {//左右剪枝
            sb.append('(');
            dfsParenthesis(n, openParentheses + 1, closeParentheses, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (openParentheses > closeParentheses) {
            sb.append(')');
            dfsParenthesis(n, openParentheses, closeParentheses + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
