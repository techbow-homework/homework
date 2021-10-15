package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;

//根据题意，只要能还原成任意一个BT就行。
//考虑BT的node 和 leaf下面的null 的关系， null = node +1；所以在loop过程中，我们查看只要有delta<0 就return false；
//到最尾的时候验证是不是delta == -1；因为结束时候BT的delta = node - null = -1；
public class LC331VerifyPreorderSerializationofaBinaryTree {

    public boolean isValidSerialization(String preorder) {
        if(preorder ==null){
            return false;
        }

        int delta = 0;

        String[] chars = preorder.split(",");

        for(String s:chars){
            if(delta < 0){
                return false;
            }

            if(s.equals("#")){
                delta--;
            }else{
                delta++;
            }
        }

        return delta == -1;
    }
}
