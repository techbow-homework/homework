package com.techbow.homework.y2021.m10.ning;

public class LC_0109 {
    // S1: primitive -- find mid
    // time: logn time recursion since every time reduce it by half, findMin takes n times,
    //      but not every time is O(n) size, so should be less than O(nlogn)
    // space: O(logn)
//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null || head.next == null) return new TreeNode();
//        return bstHelper(head, null);
//    }
//    private TreeNode bstHelper(ListNode head, ListNode tail) {
//        if (head == tail) return null;
//
//        ListNode mid = findMid(head, tail);
//
//        TreeNode root = new TreeNode(mid.val);
//        root.left = bstHelper(head, mid);
//        root.right = bstHelper(mid.next, tail);
//
//        return root;
//    }
//    private ListNode findMid(ListNode head, ListNode tail) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != tail && fast.next != tail) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

    // S2: convert linkedlist to arraylist
    // time: O(n) -- convertion
    // space: O(n) -- extra space for arraylist
//    public TreeNode sortedListToBST(ListNode head) {
//        List<Integer> array = new ArrayList<>();
//        while (head != null) {
//            array.add(head.val);
//            head = head.next;
//        }
//
//        return bstHelper(array, 0, array.size() - 1);
//    }
//    private TreeNode bstHelper(List<Integer> list, int left, int right) {
//        if (left > right) return null;
//        int mid = left + (right - left) / 2;
//        TreeNode root = new TreeNode(list.get(mid));
//
//        root.left = bstHelper(list, left, mid - 1);
//        root.right = bstHelper(list, mid + 1, right);
//
//        return root;
//    }

    // S3: inorder
    // time: O(n)
    // space: O(logn)
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        // cc
        this.head = head;
        return bstHelper(0, getLength(head) - 1);
    }
    private TreeNode bstHelper(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode leftNode = bstHelper(left, mid - 1);

        TreeNode root = new TreeNode(this.head.val);
        this.head = this.head.next;

        root.left = leftNode;
        root.right = bstHelper(mid + 1, right);

        return root;
    }
    private int getLength(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
