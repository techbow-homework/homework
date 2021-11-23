/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        //  because it's a linked list, can't access a position using index
        ListNode dummy = new ListNode();//(1)create a dummy node to hold the sorted part
        ListNode prev = dummy;//前面是empty的dummy node(pseudo)
        ListNode curr = head;//把输入的Listnode head赋予给current
        ListNode next;//新建next

        while(curr != null){//当curr不为空,即原listnode还有元素,没有完全插入sortedlist里
            next = curr.next;//把输入端的next赋予给新建的next

            while(prev.next != null && prev.next.val < curr.val){//当curr不为空(prev.next = dummy.next)
                                                                //dummy后的第一个值小于输入Listnode的值
                prev = prev.next;
            }
            curr.next = prev.next;//提取出了curr的除了第一个数

            prev.next = curr;

            prev = dummy;
            curr = next;

        }
        //原listnode都无了,dummy.next返回的是sortedlist
        return dummy.next;//(2)when we finish sorting the list,return the sorted part
    }
}

