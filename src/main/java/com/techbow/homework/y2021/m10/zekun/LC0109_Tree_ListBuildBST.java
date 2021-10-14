package com.techbow.homework.y2021.m10.zekun;

public class LC0109_Tree_ListBuildBST {
    public TreeNode sortedListToBST(ListNode head) {
        //cc
        if(head == null) return null;
        return treeBuilder(head, null);
    }

    private TreeNode treeBuilder(ListNode head, ListNode tail){
        //basecase
        if(head == tail) return null;

        ListNode rootNode = getMedian(head, tail);
        TreeNode root = new TreeNode(rootNode.val);
        root.left = treeBuilder(head, rootNode);
        root.right = treeBuilder(rootNode.next, tail);
        return root;
    }

    private ListNode getMedian(ListNode head, ListNode tail){//快慢指针找到中位置即root
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
}
