package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.List;

public class LC212_WordSearchII {
    class TrieNode{
        public char ch;
        public TrieNode[] nexts = new TrieNode[26];
        public boolean isLeaf = false;
        public TrieNode(char c){
            ch = c;
        }
    }
    public List<String> findWords(char[][] board, String[] words){
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode('\0');
        buildTrie(root, words);
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(res, root, board, visited, i, j, row, col, new StringBuilder());
            }
        }
        return res;
    }
    private void dfs(List<String> res, TrieNode root, char[][] board, boolean[][] visited, int i, int j, int row, int col, StringBuilder curPath){
        //terminate base case
        if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || root.nexts[board[i][j] - 'a'] == null) return;
        TrieNode next = root.nexts[board[i][j] - 'a'];
        visited[i][j] = true;
        curPath.append(board[i][j]);
        if(next.isLeaf){
            res.add(curPath.toString());
            next.isLeaf = false;//
        }
        dfs(res, next, board, visited, i - 1, j, row, col, curPath);
        dfs(res, next, board, visited, i + 1, j, row, col, curPath);
        dfs(res, next, board, visited, i, j - 1, row, col, curPath);
        dfs(res, next, board, visited, i, j + 1, row, col, curPath);
        visited[i][j] = false;
        curPath.deleteCharAt(curPath.length() - 1);
    }
    private void buildTrie(TrieNode root, String[] words){
        for(String e: words){
            TrieNode cur = root;
            for(int i = 0; i < e.length(); i++){
                int idx = e.charAt(i) - 'a';//convert char to digits
                if(cur.nexts[idx] == null){
                    cur.nexts[idx] = new TrieNode(e.charAt(i));
                }
                cur = cur.nexts[idx];
            }
            cur.isLeaf = true;
        }
    }
}
