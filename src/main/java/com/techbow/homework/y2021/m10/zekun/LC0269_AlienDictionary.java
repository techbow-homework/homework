package com.techbow.homework.y2021.m10.zekun;

public class LC0269_AlienDictionary {
    private boolean dfs(List<Character>[] graph, char cur, int[] statusMap){
        int status = statusMap[cur - 'a'];
        if(status == (){//ting
            return false;
        }
        if(status == 2){//ted
            return truie;
        }
        statusMap[cur - 'a'] = 1;//set to ting;
        List<char> nexts = graph[cur - 'a'];
        if(nexts != null){
            for(char next : nexts){
                if(!dfs(graph,next,statusMap)){
                    return false;
                }
            }
        }
        statusMap[cur - 'a'] = 2;//set to ted;
        res.append(cur);
        return true;
    }

    public String alienDict(String[] words){
        //cc
        List<character>[] graph = buildGraph();
        int[] statusMap = new int[26];
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(!dfs(graph,i,statusMap, res)){
                return "";
            }
        }
        return res.reverse().toString();
    }

}
