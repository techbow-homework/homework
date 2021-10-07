<<<<<<< HEAD
<<<<<<< HEAD
package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;
// length headA: a + c
// length headB: b + c
// if we make headA move what headB has moved and vice versa, a+c+b+c vs b+c+a+c, these two ptr will move together
public class LC_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return headA;

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a==null? headB : a.next;
            b = b==null? headA : b.next;
        }

        return a;
    }



}



=======
package com.techbow.homework.y2021.m09.WooWooLily;//package com.techbow.homework.y2021.m09.WooWooLily;
=======
>>>>>>> e712b1360a2a1dfc15a458929f7f885292a30596


package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;

// length headA: a + c
// length headB: b + c
// if we make headA move what headB has moved and vice versa, a+c+b+c vs b+c+a+c, these two ptr will move together



public class LC_160 {



    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return headA;

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a==null? headB : a.next;
            b = b==null? headA : b.next;
        }

        return a;
    }



}



<<<<<<< HEAD
>>>>>>> a1e7104c76f408e735a7c87017ab95e8de29924f
=======

>>>>>>> e712b1360a2a1dfc15a458929f7f885292a30596
