package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC93RestoreIPAddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 4, new ArrayList<>(), "", res);
        return res;
    }

    private static void dfs(String s, int index, int segLeft, List<String> cur, String curSeg, List<String> res){
        if(segLeft < 0 || index == s.length() && segLeft > 0) return;
        if(index == s.length() && segLeft == 0 && cur.size() == 4){
            res.add(String.join(".", cur));
        }

        for(int i = index; i < s.length() && i < index + 3; i++){
            if((s.length() - 1 - i + segLeft) / (segLeft + 1) > 3){// floor of each segment
                return;
            }
            int temp = parse(s, index, i);
            if(temp == -1) return;
            cur.add(s.substring(index, i + 1));
            //System.out.println(s.substring(index, i + 1) + " dL: "+segLeft + " cur: " +cur);
            dfs(s, i + 1, segLeft - 1, cur, curSeg, res);
            cur.remove(cur.size() - 1);
        }
    }

    private static int parse(String s, int l, int r){// l, r inclusive
        if(l == r) return (s.charAt(l) - '0');
        if(s.charAt(l) == '0'){
            return -1;
        }
        int num = Integer.parseInt(s.substring(l, r + 1));
        if(num > 255){
            return -1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));//["255.255.11.135","255.255.111.35"]
        System.out.println(restoreIpAddresses("1111")); //  1,1,1,1
        System.out.println(restoreIpAddresses("101023")); // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
    }
}
