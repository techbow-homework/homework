package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Arrays;
import java.util.List;

// output number of qualified teams.
// example skills = {4, 8, 5, 6}, minPlayers = 2, minLevel = 3, maxLevel = 7;
// output = C(3,2) + C(3,3) = 4
public class TeamFormation2 {
    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        // Write your code here
        int count = 0;
        int res = 0;
        //System.out.println(skills.toString()+ " mp " + minPlayers + " minl " + minLevel + " maxl " + maxLevel);
        for(int i : skills){
            if(i >= minLevel && i <= maxLevel){
                count ++;
            }
        }
        //System.out.println("count:" + count);
        if(count < minPlayers) return 0;
        for(int i = minPlayers; i <= count; i++){
            int cur = combination(count, i);
            res += cur;
            //System.out.println(cur);
        }

        return res;
    }
    private static int combination(int a, int b){ // C(a,b)
        long numerator = 1;
        long denominator = 1;
        for(int i = a; i > a - b; i--){
            numerator *= i;
        }
        for(int i = b; i >= 1; i--){
            denominator *= i;
        }
        return (int) (numerator/denominator);
    }

    public static void main(String[] args) {
        Integer[] skills = new Integer[] {4, 8, 5, 6};
        System.out.println(countTeams(Arrays.asList(skills),2,3,7));//4
        Integer[] skills2 = new Integer[] {12, 4, 6, 13, 5, 10};
        System.out.println(countTeams(Arrays.asList(skills2),3,4,10));//5
    }
}
