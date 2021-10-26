package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Arrays;

// "<operation> <id> <amount> <price>"
// return an array of remaining deposit after each operation
// operations will fail and then the deposits remain unchanged
public class CryptoTrading {
    public static int[] cryptoTrading(int[] deposits, String[] operations){
        int n = deposits.length;
        int len = operations.length;
        int[] shares = new int[n];
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            String s = operations[i];
            String[] sArr = s.split(" ");
            String operation = sArr[0];
            int index = Integer.parseInt(sArr[1]) - 1;
            int amount = Integer.parseInt(sArr[2]);
            //System.out.println(index + " " + amount);
            if(operation.equals("deposit")){
                deposits[index] += amount;
            }else if(operation.equals("buy")){
                int price = Integer.parseInt(sArr[3]);
                //System.out.println("price = "+ price);
                if(deposits[index] >= amount * price){
                    deposits[index] -= amount * price;
                    shares[index] += amount;
                }
            }else if(operation.equals("sell")){
                int price = Integer.parseInt(sArr[3]);
                if(shares[index] >= amount){
                    deposits[index] += amount * price;
                    shares[index] -= amount;
                }
            }
            res[i] = deposits[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] deposits = new int[]{9,7,12};
        String[] operations = new String[]{"buy 1 3 2", "sell 1 4 10", "deposit 2 12", "buy 2 10 2", "buy 2 6 3"};
        System.out.println(Arrays.toString(cryptoTrading(deposits,operations))); //[3, 3, 19, 19, 1]
    }
}
