package com.techbow.homework.y2021.m10.ryanxu.LC_140.v2;

import java.util.ArrayList;
import java.util.List;

public class LC_140_v2 {

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
                    char curCh = word.charAt(i);
                    if (curNode.nexts[curCh - 'a'] == null) {
                        curNode.nexts[curCh - 'a'] = new TrieNode();
                    }
                    curNode = curNode.nexts[curCh - 'a'];
                }
                curNode.isWord = true;
            }
        }
    }

    private TrieNode root;

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        if (s == null || wordDict == null) {
            return res;
        }

        this.root = new TrieNode();
        root.initial(root, wordDict);
        StringBuilder path = new StringBuilder();
        dfs(s, res, path, 0);
        return res;
    }

    private void dfs(String s, List<String> res, StringBuilder path, int idx) {

        int sLen = s.length();
        int pathLen = path.length();
        if (idx == sLen) {
            path.setLength(pathLen - 1);
            res.add(path.toString());
            return;
        }

        for (int i = idx; i < sLen; i++) {
            String curWord = s.substring(idx, i + 1);
            if (isMatch(curWord)) {
                path.append(curWord).append(" ");
                dfs(s, res, path, i + 1);
                path.setLength(pathLen);
            }
        }
    }

    private boolean isMatch(String curWord) {

        TrieNode curNode = this.root;
        for (int i = 0; i < curWord.length(); i++) {
            char ch = curWord.charAt(i);
            if (curNode.nexts[ch - 'a'] != null) {
                curNode = curNode.nexts[ch - 'a'];
            } else {
                return false;
            }
        }

        return curNode.isWord;
    }
}
