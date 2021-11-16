package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC1286IteratorForCombination {
    private List<String> res;
    private int resLen;
    private int curIndex;
    private int len;
    //private List<List<String>> combinations;
    public LC1286IteratorForCombination(String characters, int combinationLength) {
        res = new ArrayList<>();
        curIndex = 0;
        this.len = characters.length();
        //combinations = new ArrayList<>();
        dfs(characters, combinationLength, 0, "");
        //Collections.sort(res);
        //System.out.println(res);
        //System.out.println("a".substring(0,0));
        resLen = res.size();
    }
    private void dfs(String characters, int combinationLen, int index, String cur){
        if(cur.length() == combinationLen){
            res.add(cur);
            return;
        }
        for(int i = index; i < len; i++){
            cur = cur + characters.charAt(i);
            dfs(characters, combinationLen, i + 1, cur);
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    public String next() {
        return res.get(curIndex++);
    }

    public boolean hasNext() {
        return curIndex != resLen;
    }

    public static void main(String[] args) {
        LC1286IteratorForCombination obj = new LC1286IteratorForCombination("abc",2);
        System.out.println(obj.next());// ab
        System.out.println(obj.hasNext()); // t
        System.out.println(obj.next());// ac
        System.out.println(obj.hasNext());// t
        System.out.println(obj.next());// bc
        System.out.println(obj.hasNext());// f
    }
}

