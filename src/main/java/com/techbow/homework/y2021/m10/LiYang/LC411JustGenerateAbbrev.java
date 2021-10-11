package com.techbow.homework.y2021.m10.LiYang;

import java.util.LinkedList;
import java.util.List;
//写的是这个题中的一个模块，模块的功能是用input string创建出全部合法的简写形式；
//简写的规则是：一个字母以及连续的多个字母可以结合变成一个数字，数字等于字母的个数；简写中数字不能相邻；
//比如：apple ---> 合法：appl1, app2, 2ple, 5; 不合法： a11le, a22;
//思路：分叉方式 --> 对于string的每一个字母，是否用1替换；
//      all possilbe solution --> DFS
//      用stringbuilder来存遍历的path, 当遍历出界的时候加答案； 用num来记录连续1的个数；
//DFS内部的处理逻辑：
//case 1, sb最后的字符是数字，那么对于下一个位置就不能用1替换；向sb中append当前字母；
//case 2, sb最后的字符不是数字，那么对于下一个位置可以替换或不替换；替换 - num + 1; 不替换：先检查num的状态，再向sb中append当前字母；

public class LC411JustGenerateAbbrev {
    private void generateAbbrev(String target, int index, int num, StringBuilder sb, List<String> res){
        if(index == target.length()){
            if(num != 0){
                sb.append(String.valueOf(num));
            }
            res.add(sb.toString());
            return;
        }
        int size = sb.length();
        if(sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1))){
            sb.append(target.charAt(index));
            generateAbbrev(target,index + 1, 0, sb, res);
            sb.setLength(size);
        } else{
            if(num != 0){
                sb.append(String.valueOf(num));
            }
            sb.append(target.charAt(index));
            generateAbbrev(target,index + 1, 0, sb, res);
            sb.setLength(size);

            generateAbbrev(target,index + 1, num + 1, sb, res);
            sb.setLength(size);
        }
    }

    public static void main(String[] args){
        String s = "apple";
        LC411JustGenerateAbbrev obj = new LC411JustGenerateAbbrev();
        List<String> str = new LinkedList<>();
        obj.generateAbbrev(s,0,0,new StringBuilder(),str);
        for(String temp : str){
            System.out.println(temp);
        }
    }
}
