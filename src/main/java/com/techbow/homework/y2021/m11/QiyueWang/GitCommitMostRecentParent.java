package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;

class GitNode{
    int id;
    List<GitNode> parents;
    public GitNode(int id){
        this.id = id;
        parents = new ArrayList<>();
    }
}

public class GitCommitMostRecentParent {
    public GitNode findClosest(GitNode g1, GitNode g2){
        if(g1 == null || g2 == null) return null;
        Queue<GitNode> q1 = new LinkedList<>();
        Set<GitNode> s1 = new HashSet<>();
        Queue<GitNode> q2 = new LinkedList<>();
        Set<GitNode> s2 = new HashSet<>();
        q1.offer(g1);
        s1.add(g1);
        q2.offer(g2);
        s2.add(g2);

        while(!q1.isEmpty() && !q2.isEmpty()){
            int size1 = q1.size();
            for(int i = 0; i < size1; i++){
                GitNode temp1 = q1.poll();
                if(s2.contains(temp1)) return temp1;
                for(GitNode p1 : temp1.parents){
                    if(!s1.contains(p1)) {
                        q1.offer(p1);
                        s1.add(p1);
                    }
                }
            }

            int size2 = q2.size();
            for(int i = 0; i < size2; i++){
                GitNode temp2 = q2.poll();
                if(s1.contains(temp2)) return temp2;
                for (GitNode p2 : temp2.parents){
                    if(!s2.contains(p2)) {
                        q2.offer(p2);
                        s2.add(p2);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GitCommitMostRecentParent obj = new GitCommitMostRecentParent();
        GitNode g1 = new GitNode(1);
        GitNode g2 = new GitNode(2);
        GitNode g3 = new GitNode(3);
        GitNode g4 = new GitNode(4);
        GitNode g5 = new GitNode(5);
        GitNode g6 = new GitNode(6);

        g1.parents.add(g3);
        g1.parents.add(g4);
        g2.parents.add(g4);
        g3.parents.add(g5);
        g4.parents.add(g5);
        g4.parents.add(g6);

//           6
//            \
//        5 -> 4 -> 2
//         \    \
//          3 -> 1

        GitNode res = obj.findClosest(g1,g2);
        GitNode res2 = obj.findClosest(g6,g3);
        System.out.println(res != null ? res.id : null);
        System.out.println(res2 != null ? res2.id : null);
    }
}
