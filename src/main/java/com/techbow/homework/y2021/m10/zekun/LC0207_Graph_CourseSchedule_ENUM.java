package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0207_Graph_CourseSchedule_ENUM {
    public static void main(String[] args){
        LC0207_Graph_CourseSchedule_ENUM obj = new LC0207_Graph_CourseSchedule_ENUM();
        int numCourses = 2;
        int[][] prereq = new int[][]{{1,0}, {0,1}};

        boolean sol = obj.canFinish(numCourses, prereq);
        System.out.println(sol);
    }
    private enum Status{
        INITIAL, VISITING, VISITED;
    }
    private static class V{
        public int label;
        public List<Integer> nexts;
        public Status status;
        public V(int lable){
            this.label = label;
            this.nexts = new ArrayList<Integer>();
            status = Status.INITIAL;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //cc
        if(numCourses == 0) return false;

        //convert 2d array to graph
        V graph[] = new V[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new V(i);
        }
        int edgesNum = prerequisites.length;
        for(int i = 0; i < edgesNum; i++){
            int prev = prerequisites[i][1];
            int next = prerequisites[i][0];
            graph[prev].nexts.add(next);
        }

        for(int i = 0; i < numCourses; i++){
            if(dfsGraph(graph[i], graph)){
                return false;
            }
        }
        return true;
    }

    private boolean dfsGraph(V source, V[] graph){
        //sucess base case;
        if(source.status == Status.VISITED) return false;

        if(source.status == Status.VISITING) return true;

        source.status = Status.VISITING;
        for(int i : source.nexts){
            if(dfsGraph(graph[i], graph)){
                return true;
            }
        }
        source.status = Status.VISITED;
        return false;

    }
}
