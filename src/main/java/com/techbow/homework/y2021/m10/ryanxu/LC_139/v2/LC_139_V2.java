package com.techbow.homework.y2021.m10.ryanxu.LC_139.v2;

import java.util.Arrays;
import java.util.List;

public class LC_139_V2 {

    private static class TrieNode {

        private TrieNode[] nexts;
        private boolean isWord;

        public TrieNode() {
            this.nexts = new TrieNode[26];
        }

        private void initial(TrieNode root, List<String> list) {

            for (String word : list) {
                TrieNode curNode = root;
                for (int i = 0; i < word.length(); i++) {
                    char cur = word.charAt(i);
                    if (curNode.nexts[cur - 'a'] == null) {
                        curNode.nexts[cur - 'a'] = new TrieNode();
                    }
                    curNode = curNode.nexts[cur - 'a'];
                }
                curNode.isWord = true;
            }
        }
    }

    private TrieNode root;

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null) {
            return false;
        }

        this.root = new TrieNode();
        root.initial(root, wordDict);
        int strLen = s.length();
        Boolean[] memo = new Boolean[strLen];
        return dfs(s, 0, memo);

    }

    private boolean dfs(String s, int idx, Boolean[] memo) {

        int strLen = s.length();
        if (idx == strLen) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        TrieNode curNode = this.root;
        for (int i = idx; i < strLen; i++) {
            if (curNode.nexts[s.charAt(i) - 'a'] != null) {
                curNode = curNode.nexts[s.charAt(i) - 'a'];
                if (curNode.isWord && dfs(s, i + 1, memo)) {
                    memo[idx] = true;
                    return true;
                }
            } else {
                break;
            }
        }

        memo[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        LC_139_V2 lc_139_v2 = new LC_139_V2();
        String s = "bb";
        List<String> wordDict = Arrays.asList("a","b","bbb","bbbb");
        System.out.println(lc_139_v2.wordBreak(s, wordDict));
    }
}
