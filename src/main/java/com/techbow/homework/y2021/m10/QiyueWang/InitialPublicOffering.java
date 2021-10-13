package com.techbow.homework.y2021.m10.QiyueWang;
// the bidder with the highest price get the number of shares they bid for
// if many bidders bid at the same price, each of them are assigned one share each turn based on timestamp
// output the userID that not getting any shares, sorted in ascending order.
// bid comes in the form (userID, number of shares, bidding price, timestamp)
// example: bids = {{1,5,5,0},{2,7,8,1},{3,7,5,1},{4,10,3,3}}, totalShares = 18
// out put is [4]


import java.util.*;

public class InitialPublicOffering {
    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
        // Write your code here
        //int n = bids.size();
        List<Integer> res = new ArrayList<>();
        // pq to sort by bid price first then timestamp
        Queue<List<Integer>> pq = new PriorityQueue<>((a,b)-> a.get(2) == b.get(2) ? a.get(3) - b.get(3) : b.get(2) - a.get(2));
        for(List<Integer> b : bids){
            pq.offer(b);
        }

        //check if a group of user having same bid price could take out all remaining shares
        int remain = totalShares;
        List<Integer> extraUsers = new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> cur = pq.poll();
            List<List<Integer>> sameBid = new ArrayList<>();
            sameBid.add(cur);

            int curSum = cur.get(1);
            while(!pq.isEmpty() && pq.peek().get(2) == cur.get(2)){ // having same bid
                List<Integer> temp = pq.poll();
                sameBid.add(temp);
                curSum += temp.get(1);
            }
            // if taken out all remaining, check if everyone has one share or not
            if(curSum >= remain){
                extraUsers = checkUnallotted(sameBid, remain);
                break;
            }
            // if not taken out, check for next group having same bid
            remain -= curSum;
        }
        // if there is someone with same bid but having no share, put into res
        if(!extraUsers.isEmpty()){
            for(int i : extraUsers){
                res.add(i);
            }
        }
        // put the rest of the records into res, b/c totalShares has taken out
        while(!pq.isEmpty()){
            res.add(pq.poll().get(0));
        }
        // sort by userID
        Collections.sort(res);
        return res;
    }
    // check if remaining shares is enough for everyone to have at least one share
    private static List<Integer> checkUnallotted(List<List<Integer>> sameBid, int remain){
        int n = sameBid.size();
        List<Integer> res = new ArrayList<>();
        if(remain >= n) return res;
        for(int i = remain; i < n; i ++){
            res.add(sameBid.get(i).get(0));
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[][] bidsArr = new Integer[][] {{1,5,5,0},{2,7,8,1},{3,7,5,1},{4,10,3,3}};
        int totalShares = 7;
        List<List<Integer>> bids = new ArrayList<>();
        for(Integer[] b : bidsArr){
            bids.add(Arrays.asList(b));
        }
        List<Integer> res;
        res = getUnallottedUsers(bids, totalShares);
        System.out.println(res.toString());
    }
}
