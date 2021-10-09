package com.techbow.homework.y2021.m10.zekun;

public class LC0653_TwoSumIV {

    如何在不拉直的前提下，模拟一维的sorted array 用双指针解？
    left指针对应了sorted array的第0个，right指针对应了sortedarray的n-1个；
    然后如何做到left++，right--？这里放在BST的背景下，就是要找inorder 之下的successor和predecessr
    这里的难点：如何找left most，right most，以及如何找successor，如何找predecessor。
    这里讲到，如何借助stack，找inorder的successor和predecessor：即每次把当前node连同右子树加到stack里面；

}
