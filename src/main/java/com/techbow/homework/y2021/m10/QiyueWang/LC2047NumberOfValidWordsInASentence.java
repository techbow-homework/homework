package com.techbow.homework.y2021.m10.QiyueWang;

public class LC2047NumberOfValidWordsInASentence {
    public static int countValidWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();
        String[] sArr = sentence.split(" ");
        int count = 0;
        //System.out.println(Arrays.toString(sArr));
        for(String s : sArr){
            int n = s.length();
            int countH = 0;

            for(int i = 0; i < n; i++){
                char cur = s.charAt(i);

                if(Character.isDigit(cur)) {
                    count --;
                    break;
                }
                if(cur == '-'){
                    countH ++;
                    if(countH > 1 || i == 0 || i == n - 1 || i == n - 2 && !Character.isLetter(s.charAt(n - 1))) { // prevent "a-!"
                        count --;
                        break;
                    }
                }
                if((cur == ',' || cur == '.' || cur == '!') && i != n - 1  ){
                    count --;
                    break;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] tests = new String[]{"cat and  dog",
                "!this  1-s b8d!",
                "alice and  bob are playing stone-game10",
                "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.", "a-!"};
        for (String s : tests){
            System.out.println(countValidWords(s)); // 3 0 5 6 0
        }
    }
}
