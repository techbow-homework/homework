package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法加强.stack;

import java.util.Stack;

public class LC255VerifyPreOrderSequenceInBinarySearchTree {


    //利用BST的特性，node的左边的所有值都比他小，右边的都比他大，所以当preorder时候，应该是一个大约降序，然后绝对升序的一个array；如果input是这样一个array 则证明是true；大约降序是因为有可能[521346] 降到1后有来了3 和4，都在root的左边但是比1大。绝对的升序是因为右边不能有在比这个值小的element。
    //维护一个降序的stack，
    //当这个 element比stack里的top的值大的时候，有可能是低价
    public boolean verifyPreorder(int[] preorder) {

        if( preorder == null || preorder.length == 0){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;

        for(int val:preorder){
            if(val<low){
                return false;
            }

            while(!stack.isEmpty() && val > stack.peek()){
                low = stack.pop();
            }

            stack.push(val);
        }
        return true;
    }
}
