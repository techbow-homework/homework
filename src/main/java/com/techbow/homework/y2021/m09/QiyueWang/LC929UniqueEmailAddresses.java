package com.techbow.homework.y2021.m09.QiyueWang;

import java.util.HashSet;
import java.util.Set;

public class LC929UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        int res = 0;
        int n = emails.length;

        Set<String> hash = new HashSet<>();

        for (String s : emails) {
            boolean metA = false; // if met @
            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {

                if (!metA) {
                    if (s.charAt(i) == '.') continue;
                    if (s.charAt(i) == '@') {
                        metA = true;
                        cur.append(s.charAt(i));
                        continue;
                    }
                    if (s.charAt(i) == '+') {
                        while (i < s.length() && s.charAt(i) != '@') {
                            i++;
                        }
                        metA = true;
                        cur.append(s.charAt(i));
                        continue;
                    }
                    cur.append(s.charAt(i));
                } else {
                    cur.append(s.charAt(i));
                }
            }
            //System.out.println(cur.toString());
            hash.add(cur.toString());
        }
        return hash.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}; // expect 2
        String[] emails2 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"}; // expect 3
        int res = numUniqueEmails (emails);
        System.out.println(res);
    }
}
//time O(LN) space O(N)