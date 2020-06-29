//time complexity- O(nlogK)

//space complexity- O(k)
import java.util.*;
public class MergeKSortedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    static void printList(ListNode temp) {
        while(temp != null) {
            System.out.print(temp.val);
            if(temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
    }
    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);

        for(ListNode head: lists) {
            if(head != null) pq.add(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = temp;

            if(temp.next != null) pq.offer(temp.next);
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        //4->6
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(6);

        //1->2->4->5
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);
        head2.next .next.next = new ListNode(5);

        //3->4->5
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(4);
        head3.next.next = new ListNode(5);

        ListNode[] list = {head1, head2, head3};
        ListNode head = mergeKLists(list);
        printList(head);

    }
}
