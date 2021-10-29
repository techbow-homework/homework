package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.*;

public class LC752OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;
        int n = deadends.length;
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String s : deadends){
            dead.add(s);
        }
        if(dead.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                for(String s : getNext(cur)){
                    if(dead.contains(s) || visited.contains(s)) continue;
                    if(target.equals(s)) {
                        // System.out.println(getNext(cur).toString());
                        // System.out.println(cur);
                        return res;
                    }
                    visited.add(s);
                    q.offer(s);

                }
            }
            res++;
        }
        //System.out.println(getNext("0000").toString());
        return -1;
    }
    private static List<String> getNext(String s){
        StringBuilder sb = new StringBuilder(s);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            char temp = sb.charAt(i);
            if(temp == '9') sb.replace(i, i+1, "0");
            else sb.replace(i, i+1, String.valueOf(temp + 1 - '0'));
            res.add(sb.toString());
            if(temp == '0') sb.replace(i, i+1, "9");
            else sb.replace(i, i+1, String.valueOf(temp - 1 - '0'));
            res.add(sb.toString());
            sb.replace(i, i+1, String.valueOf(temp));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends,"0202")); // 6
        String[] deadends2 = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(openLock(deadends2,"8888")); // -1
    }
}
// time O(10^4*4 + 4*n) space O(10^4*4 + 4*n)
// 10^4 for total status, 4 for iterating through 4 bits, n for length of deadends
