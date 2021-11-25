package com.techbow.homework.y2021.m11.mengyu;

public class LC205 {
    public boolean isIsomorphic(String s, String t) {
        /*
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i))) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
            set.add(t.charAt(i));

        }
        return true;
    }
    */
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1[c1] != m2[c2]) return false;
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }
        return true;
    }
}
