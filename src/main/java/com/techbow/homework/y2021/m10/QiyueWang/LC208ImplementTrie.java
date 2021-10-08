package com.techbow.homework.y2021.m10.QiyueWang;
class TrieNode{
    private char val;
    private TrieNode[] children;
    private boolean isEnd;

    public TrieNode(char v){
        val = v;
        children = new TrieNode[26];
        isEnd = false;
    }
    public char getVal(){
        return val;
    }

    public TrieNode[] getChildren(){
        return children;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public void setEnd(boolean b){
        isEnd = b;
    }

}


class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode('0');
    }


    public void insert(String word) {
        int n = word.length();
        TrieNode node = root;
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            TrieNode[] cur = node.getChildren();
            if(cur[c - 'a'] == null){
                cur[c - 'a'] = new TrieNode(c);
            }
            node = cur[c - 'a'];
        }
        node.setEnd(true);
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode node = root;
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            TrieNode[] cur = node.getChildren();
            if(cur[c - 'a'] == null || c != cur[c - 'a'].getVal()){
                return false;
            }
            node = cur[c - 'a'];
            if(i == n - 1 && node.isEnd()){
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode node = root;
        for(int i = 0; i < n; i++){
            char c = prefix.charAt(i);
            TrieNode[] cur = node.getChildren();
            if(cur[c - 'a'] == null || c != cur[c - 'a'].getVal()){
                return false;
            }
            node = cur[c - 'a'];
            // if(i == n - 1 && node.isEnd()){
            //     return true;
            // }
        }
        return true;
    }
}

public class LC208ImplementTrie {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple")); // true
        System.out.println(obj.search("app")); // false
        System.out.println(obj.startsWith("app")); // true
        obj.insert("app");
        System.out.println(obj.search("app")); // true
    }
}
// each insert, search, startWith operation time O(m)