package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;

//in queries, each string has the format "A <name>" or "D <name>". "A" for allocate and "D" for deallocate.
// When allocating a <name>, append the index(1,2,3,4 ...) to the <name> as the real name in the system. Always append the smallest missing index.
// When deallocating, need to specify the index, such as tracker.deallocate("name1"). It is valid to deallocate an index not exist.

public class Tracker {
    private Map<String, Set<Integer>> allocated;
    private Map<String, Set<Integer>> deallocated;

    public Tracker(){
         allocated = new HashMap<>();
         deallocated = new HashMap<>();
    }
    public String allocate(String name){
        Set<Integer> curAlo = allocated.getOrDefault(name, new HashSet<>());
        Set<Integer> curDlo = deallocated.getOrDefault(name, new HashSet<>());
        int num = 0;

        if(curDlo.size() == 0){
            num = curAlo.size() + 1; // should be in sequence
            //System.out.println("Dlo zero "+num);
        }else if(curDlo.size() != 0){
            Queue<Integer> heap = new PriorityQueue<>(curDlo);
            num = heap.poll();
            //System.out.println("Dlo non zero "+num);
            curDlo.remove(num);
            deallocated.put(name, curDlo);
        }else if(curAlo.size() == 0){
            num = 1;
            //System.out.println("Alo zero "+num);
        }

        curAlo.add(num); // add to allocated
        allocated.put(name,curAlo);
        return name + String.valueOf(num);
    }
    public void deallocate(String name){
        if(!Character.isDigit(name.charAt(name.length() - 1))) return; // if no number
        String[] parsedName = parseName(name);
        int num = Integer.parseInt(parsedName[1]);
        String realName = parsedName[0];
        Set<Integer> curAlo = allocated.getOrDefault(realName, new HashSet<>());
        if(curAlo.size() == 0 ){ // if not allocated
            return;
        }
        if(curAlo.contains(num)){
            curAlo.remove(num); // delete from allocated
            Set<Integer> curDlo = deallocated.getOrDefault(realName, new HashSet<>());
            curDlo.add(num);
            deallocated.put(realName, curDlo);
        }
        return;
    }
    private String[] parseName(String name){
        int n = name.length();
        int i = 0;
        while(i < n){
            if(Character.isDigit(name.charAt(i))){
                break;
            }
            i++;
        }
        return new String[]{name.substring(0, i), name.substring(i)};
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        System.out.println(tracker.allocate("a"));//a1
        System.out.println(tracker.allocate("a"));//a2
        System.out.println(tracker.allocate("b"));//b1
        tracker.deallocate("a1");
        tracker.deallocate("b1");
        System.out.println(tracker.allocate("a"));//a1
        System.out.println(tracker.allocate("a"));//a3
        tracker.deallocate("a2");
        System.out.println(tracker.allocate("a"));//a2
    }
}
