package com.techbow.homework.y2021.m11.shengyuan;

import java.util.HashMap;
import java.util.Map;

/** case 1:
 *  a    b    c    a
 *      left
 *                right
 *  count
 *  HashMap <Character, Integer>
 *  case 2:
 *   a    b     c     c
 *                  left
 *                  right
 */

public class LC_3 {
    public int longestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int left = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < str.length(); right++ ) {
            char c = str.charAt(right);
            Integer index = map.get(c);
            if (index != null) {
                left = Math.max(index + 1, left);              //left = index + 1
            }
            map.put(c, right);
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        LC_3 test = new LC_3();
        String str = "abcabcbb";
        int result = test.longestSubstring(str);
        System.out.println(result);
    }
}
