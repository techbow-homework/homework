package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.ArrayList;
import java.util.List;

public class LC212WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        for(String w : words){
            search:{
                for(int i = 0; i < m ; i++){
                    for(int j = 0; j < n; j++){
                        if(dfs(board, w, 0, i, j, res, new boolean[m][n])){
                            res.add(w);
                            //System.out.println(w + " i j : " +i+j);
                            break search;
                        }
                    }
                }
            }
        }
        return res;
    }

    private static boolean dfs(char[][] board, String word, int index, int i, int j, List<String> res, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }

        visited[i][j] = true;
        boolean cur = dfs(board, word, index + 1, i + 1, j, res, visited) ||dfs(board, word, index + 1, i - 1, j, res, visited) || dfs(board, word, index + 1, i, j + 1, res, visited)|| dfs(board, word, index + 1, i, j - 1, res, visited);
        visited[i][j] = false;
        return cur;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        char[][] board2 = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String[] words2 = {"ABCB"};
        System.out.println(findWords(board, words)); // ["eat","oath"]
        System.out.println(findWords(board2, words2)); // []
    }
}
