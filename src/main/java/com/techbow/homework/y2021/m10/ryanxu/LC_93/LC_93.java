package com.techbow.homework.y2021.m10.ryanxu.LC_93;

import java.util.ArrayList;
import java.util.List;

public class LC_93 {
    public List<String> restoreIpAddresses(String s) {

        if (s == null) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(res, path, 0, s, 0);

        return res;
    }

    private void dfs(List<String> res, StringBuilder path, int idx, String s, int parts) {

        int strLen = s.length();
        if (idx == strLen && parts == 4) {
            path.setLength(path.length() - 1);
            res.add(path.toString());
            return;
        }

        if (idx == strLen || parts == 4) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (idx + len > strLen) {
                break;
            }

            int curPathLen = path.length();
            int curNum = Integer.valueOf(s.substring(idx, idx + len));
            if (curNum == 0) {
                path.append(curNum + ".");
                dfs(res, path, idx + len, s, parts + 1);
                path.setLength(curPathLen);
                break; // 001 invalid 如果是0，就要直接挪动idx
            } else if (curNum <= 255) {
                path.append(curNum + ".");
                dfs(res, path, idx + len, s, parts + 1);
                path.setLength(curPathLen);
            }
        }
    }

    public static void main(String[] args) {
        LC_93 lc_93 = new LC_93();
        System.out.println(lc_93.restoreIpAddresses("000"));
    }
}
