package com.techbow.homework.y2021.m10.zekun;

public class LC0463_IslandPerimeter {
    public int isLandPerimeter(inT
        int nrow = island.length;
        int ncol = island[0].length;
        int ilp = 0;
        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(island[i][j] == 1){
                    ilp += 4;
                    if(i > 0 && island[i - 1][j] == 1){
                        ilp -= 2;
                    }
                    if(j > 0 && island[i][j - 1] == 1){
                        ilp -= 2;
                    }
                }
            }
        }
        return ilp;
    }
}
