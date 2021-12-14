package com.techbow.homework.y2021.m10.zekun;

public class LC0721_AccountsMerge_UnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //cc
        if(accounts == null) throw new IllegalArgumentException();
        int len = accounts.size();
        UnionFind uf = new UnionFind(len);

        //this part: every i of accounts.length is a user, we iterate through the users,
        //and build hashmap, if a email is existed in the map, so we union its users;
        //if a email is not existed in the map, we add it.
        Map<String, Integer> emailToUserMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            List<String> accounti = new ArrayList<>();
            for(int j = 0; j < accounti.size(); j++){
                String email = accounti.get(j);
                Integer user = emailToUserMap.get(email);
                if(user == null){
                    emailToUserMap.put(email, i);
                }else{
                    uf.union(user, i);
                }
            }
        }
        //this part: for each user, we will have a hashset to store its emails
        //so we will loop all the users, check if it exists in the userToEmailMap,
        //if exists, we just add all new emails to its corresponding hashset;
        //if not exists, we just creat a hashMap pair and put the value into it.
        Map<Integer, HashSet<String>> userToEmailMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            int root = uf.getRoot(i); // find the root of each i user
            if(!userToEmailMap.containsKey(root)){
                userToEmailMap.put(root, new HashSet<String>());
            }
            for(int j = 0; j < accounts.get(i).size(); j++){
                userToEmailMap.get(root).add(accounts.get(i).get(j));
            }
        }

        //
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, HashSet<String>> e : userToEmailMap.entrySet()){
            List<String> list = new ArrayList<>();
            list.addAll(e.getValue());
            Collections.sort(list);
            list.add(0, accounts.get(e.getKey()).get(0));
            res.add(list);
        }
        return res;
    }
}

class UnionFind{
    int[] parents;
    int[] size;
    public UnionFind(int len){
        parents = new int[len];
        size = new int[len];
    }

    public int getRoot(int p){
        int cur = p;
        while(parents[cur] != cur){
            //cur.parent = cur.parent.parent;
            parents[cur] = parents[parents[cur]];
            //cur = cur.parent;
            cur = parents[cur];
        }
        parents[p] = cur;//p.parent = cur;
        return cur;
    }
    public boolean find(int p, int q){
        return getRoot(p) == getRoot(q);
    }
    public void union(int p, int q){
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if(size[pRoot] > size[qRoot]){//
            parents[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }else{
            parents[pRoot] = qRoot;
            size[qRoot] += size[qRoot];
        }
    }

    public void initialI(int len){
        for(int i = 0; i < len; i++){
            parents[i] = i;
            size[i] = 1;
        }
    }
}
