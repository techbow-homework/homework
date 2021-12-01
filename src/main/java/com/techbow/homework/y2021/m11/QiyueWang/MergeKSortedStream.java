package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.*;

class Stream{
    Iterator<Integer> iter;
    public Stream(List<Integer> list){
        this.iter = list.iterator();
    }
    public boolean move(){
        return iter.hasNext();
    }
    public int getValue(){
        return iter.next();
    }
}

class Num{
    int val;
    Stream stream;
    public Num(Stream stream){
        this.stream = stream;
        this.val = stream.getValue();
    }
}

public class MergeKSortedStream {
    public List<Integer> numAtLeastKOccurance(List<Stream> streamList, int k){
        List<Integer> res = new ArrayList<>();
        Queue<Num> minHeap = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o1.val - o2.val;
            }
        });
        //put all streams into the heap
        for(Stream s : streamList){
            if(s.move()){
                minHeap.offer(new Num(s));
            }
        }

        while(!minHeap.isEmpty()){
            if(minHeap.size() < k) {// check enough streams
                //System.out.println(minHeap.size());
                break;
            }

            Num cur = minHeap.poll();
            int curVal = cur.val;
            int count = 1;
            //put in next val
            while(cur.stream.move()){
                Num nextNum = new Num(cur.stream);
                int nextVal = nextNum.val;
                if(curVal == nextVal) continue;
                minHeap.offer(nextNum);
                break;
            }
            // check other streams on curVal
            while(!minHeap.isEmpty() && minHeap.peek().val == curVal){
                count++;
                Num temp = minHeap.poll();
                while(temp.stream.move()){
                    Num nextNum = new Num(temp.stream);
                    int nextVal = nextNum.val;
                    if(curVal == nextVal) continue;
                    minHeap.offer(nextNum);
                    break;
                }
            }
            if(count >= k){
                res.add(curVal);
            }

        }
        return res;
    }
    public static void main(String[] args) {
        MergeKSortedStream test = new MergeKSortedStream();
        Integer[] arr1 = {1,2,3,4,1,1,1,1,1,1,1,1,1,1,1,1};
        Integer[] arr2 = {2,5,6};
        Integer[] arr3 = {2,4,5,7};

        List<Integer> l1 = Arrays.asList(arr1);
        List<Integer> l2 = Arrays.asList(arr2);
        List<Integer> l3 = Arrays.asList(arr3);

        List<Stream> lists = new ArrayList<>();
        lists.add(new Stream(l1));
        lists.add(new Stream(l2));
        lists.add(new Stream(l3));

        List<Integer> res = test.numAtLeastKOccurance(lists, 2);
        System.out.println(res);
    }
}
