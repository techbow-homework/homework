package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
    private boolean isEnd;
    public TrieNode[] children;
    public TrieNode(){
        isEnd = false;
        children = new TrieNode[26];
    }
    public void insert(String word){
        int n = word.length();
        TrieNode tn = this;
        for (int i = 0; i < n; i++){
            char cur = word.charAt(i);
            if(tn.children[cur - 'a'] == null){
                tn.children[cur - 'a'] = new TrieNode();
            }
            tn = tn.children[cur - 'a'];
        }
        tn.isEnd = true;
    }
    public TrieNode find(String word){
        int n = word.length();
        TrieNode tn = this;
        for (int i = 0; i < n; i++){
            char cur = word.charAt(i);
            if(tn.children[cur - 'a'] == null){
                return null;
            }
            tn = tn.children[cur - 'a'];
        }
        return tn;
    }
    public boolean hasWord(){
        return this.isEnd;
    }
}

public class AutoComplete {
    private List<String> dict;
    private TrieNode root;

    public AutoComplete(String[] dict){
        root = new TrieNode();
        this.dict = new ArrayList<>();
        for(String s : dict) {
            this.dict.add(s);
        }
    }
    public AutoComplete(){
        root = new TrieNode();
        this.dict = new ArrayList<>();
    }

    public void insertAll(){
        for(String s : dict){
            root.insert(s);
        }
    }

    public List<String> findAll(String prefix){
        List<String> res = new ArrayList<>();
        if(prefix == null || prefix.equals("")){
            return res;
        }
        TrieNode start = root.find(prefix);
        //System.out.println(start.hasWord());
        dfs(start, prefix, res);
        return res;
    }

    private void dfs(TrieNode start, String prefix, List<String> res){
        if(start == null) return;
        if(start.hasWord()){
            res.add(prefix);
        }
        for(int i = 0; i < 26; i++){
            if(start.children[i] != null){
                dfs(start.children[i], prefix + (char)(i + 'a'), res);
            }
        }
    }

    public static void main(String[] args) {
        String[] dict = {
                "marketing",
                "make",
                "stop",
                "development",
                "develop",
                "dev"
        };
        AutoComplete sol = new AutoComplete(dict);
        sol.insertAll();//initialization
        System.out.println(sol.findAll("de"));
        System.out.println(sol.findAll("dev"));
        System.out.println(sol.findAll("s"));
        System.out.println(sol.findAll("a"));
        System.out.println(sol.findAll("m"));
    }
}
