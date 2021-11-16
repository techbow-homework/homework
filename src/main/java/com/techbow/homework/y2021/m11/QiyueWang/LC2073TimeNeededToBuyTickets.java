package com.techbow.homework.y2021.m11.QiyueWang;

public class LC2073TimeNeededToBuyTickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int num = tickets[k];
        int sum = (num - 1) * n + 1;//+1 for itself
        for(int i = 0; i < n; i++){
            int cur = tickets[i];
            if(cur < num){
                sum -= num - cur - 1;
            }else if(i < k){
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] tickets = new int[]{2,3,2};
        System.out.println(timeRequiredToBuy(tickets, 2));//6
    }
}
