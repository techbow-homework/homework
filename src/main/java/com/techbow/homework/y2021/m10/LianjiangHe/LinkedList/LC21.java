//option1 改变了list1 list2 dummy作为容器,curr每次往后移一格,
// 改变了curr和dummy后面的部分,但没有移动的那个node就永远保存在dummy里了
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //cc
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        //while loop
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        //post processing
        if(list1 == null){
            curr.next = list2;
        }
        if(list2 == null){
            curr.next = list1;
        }
        return dummy.next;
    }
}

//option 2 recursion
//如果list1的值较小,list1的下一个就是list1的下一个和list2的merge后的list,反之亦然
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}