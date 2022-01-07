package com.techbow.homework.y2021.m10.ryanxu.LC_1032;

public class StreamChecker {

    private static class TrieNode {
        private TrieNode[] nexts;
        private boolean isWord;

        public TrieNode() {
            this.nexts = new TrieNode[26];
        }

        private void addWord(String word) {

            TrieNode cur = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (cur.nexts[word.charAt(i) - 'a'] == null) {
                    cur.nexts[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.nexts[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }

        private boolean valid(String str) {

            TrieNode cur = this;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (cur.nexts[str.charAt(i) - 'a'] != null) {
                    cur = cur.nexts[str.charAt(i) - 'a'];
                    if (cur.isWord) {
                        return true;
                    }
                } else {
                    break;
                }
            }
            return false;
        }
    }

    private TrieNode root;
    private String str;

    public StreamChecker(String[] words) {

        this.root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
    }

    public boolean query(char letter) {

        this.str += letter;
        return this.root.valid(this.str);
    }
}
