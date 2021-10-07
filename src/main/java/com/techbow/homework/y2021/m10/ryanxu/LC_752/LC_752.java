package com.techbow.homework.y2021.m10.ryanxu.LC_752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC_752 {
    public int openLock(String[] deadends, String target) {

        if (deadends == null || deadends.length == 0 || target == null) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        HashSet<String> deadendsSet = new HashSet<>();
        for (String str : deadends) {
            if (str.equals("0000") || str.equals(target)) {
                return -1;
            }
            deadendsSet.add(str);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] curNum = cur.toCharArray();
                for (int i = 0; i < cur.length(); i++) {
                    char curDigit = curNum[i];
                    // clockwise
                    char cDigit = Character.forDigit((curDigit - '0' + 1) % 10, 10);
                    if (turnWheel(target, deadendsSet, queue, visited, curNum, i, curDigit, cDigit)) return res + 1;

                    // anticlockwise
                    char aDigit = Character.forDigit((curDigit - '0' - 1 + 10) % 10, 10);
                    if (turnWheel(target, deadendsSet, queue, visited, curNum, i, curDigit, aDigit)) return res + 1;
                }
            }
            res++;
        }
        return -1;
    }

    private boolean turnWheel(String target, HashSet<String> deadendsSet, Queue<String> queue, HashSet<String> visited,
                              char[] curNum, int i, char curDigit, char cDigit) {
        curNum[i] = cDigit;
        String cNext = String.valueOf(curNum);
        if (cNext.equals(target)) {
            return true;
        }
        if (!deadendsSet.contains(cNext) && !visited.contains(cNext)) {
            visited.add(cNext);
            queue.add(cNext);
        }
        curNum[i] = curDigit;
        return false;
    }

    public static void main(String[] args) {
        LC_752 lc_752 = new LC_752();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(lc_752.openLock(deadends, target));
    }
}
