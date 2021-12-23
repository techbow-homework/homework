package LC_472;

import java.util.*;

public class LC_472 {

    private static class TrieNode {
        private TrieNode[] nexts;
        private boolean isWord;
        public TrieNode() {
            this.nexts = new TrieNode[26];
        }

        public void addWord(String word) {

            TrieNode cur = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char curCh = word.charAt(i);
                if (cur.nexts[curCh - 'a'] == null) {
                    cur.nexts[curCh - 'a'] = new TrieNode();
                }
                cur = cur.nexts[curCh - 'a'];
            }
            cur.isWord = true;
        }

        public boolean containsWord(String word) {

            TrieNode cur = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char curCh = word.charAt(i);
                if (cur.nexts[curCh - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[curCh - 'a'];
            }

            return cur.isWord;
        }
    }

    private TrieNode root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        if (words == null || words.length == 0) {
            return null;
        }

        Comparator<String> comparator = (a, b) -> (a.length() - b.length());
        Arrays.sort(words, comparator);
        List<String> res = new ArrayList<>();
        this.root = new TrieNode();
        for (String word : words) {
            if (!word.equals("") && isValid(word)) {
                res.add(word);
            }
            this.root.addWord(word);
        }

        return res;
    }

    private boolean isValid(String word) {

        Boolean[] memo = new Boolean[word.length() + 1];
        return dfs(word, 0, memo);
    }

    private boolean dfs(String word, int idx, Boolean[] memo) {

        int len = word.length();
        if (idx == len) {
            memo[idx] = true;
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int i = idx; i < len; i++) {
            String curSubStr = word.substring(idx, i + 1);
            if (this.root.containsWord(curSubStr) && dfs(word, i + 1, memo)) {
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }
}
