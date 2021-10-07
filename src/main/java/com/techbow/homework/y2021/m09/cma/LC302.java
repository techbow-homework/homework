package com.techbow.homework.y2021.m09.cma;

public class LC302 {
    class Solution {
        public int minArea(char[][] image, int x, int y) {
            int rowLen = image.length;
            int colLen = image[0].length;
            int left = 0, right = 0, top = 0, down = 0;
            int start = 0, med = 0, end = 0;

            int i = 0, j = 0;

            // left
            start = 0;
            end = y;

            while(start <= end){
                med = start + (end - start)/2;

                for(i = 0; i < rowLen; i ++){
                    if(image[i][med] == '1'){
                        end = med - 1;
                        break;
                    }
                }
                if(i == rowLen){
                    start = med + 1;
                }
                left = start;
            }

            // right
            start = y;
            end = colLen - 1;
            while(start <= end){
                med = start + (end - start)/2;
                for(i = 0; i < rowLen; i ++){
                    if(image[i][med] == '1'){
                        start = med + 1;
                        break;
                    }
                }
                if(i == rowLen){
                    end = med - 1;
                }
                right = end;
            }

            // top
            start = 0;
            end = x;
            while(start <= end){
                med = start + (end- start)/2;
                for(j = 0; j < colLen; j ++){
                    if(image[med][j] == '1'){
                        end = med - 1;
                        break;
                    }
                }
                if(j == colLen){
                    start = med + 1;
                }
                top = start;
            }

            // down
            start = x;
            end = rowLen - 1;
            while(start <= end){
                med = start + (end- start)/2;
                for(j = 0; j < colLen; j ++){
                    if(image[med][j] == '1'){
                        start = med + 1;
                        break;
                    }
                }
                if(j == colLen){
                    end = med -1;
                }
                down = end;
            }
            return (right - left + 1) *(down - top + 1);
        }

    }
}
