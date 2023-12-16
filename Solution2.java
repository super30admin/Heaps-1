//merge k sorted lists
//TC ->N(logk)
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

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {

        //min heap make it
        //custom comparator
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head:lists)
        {
            if(head!=null)
            {
            pq.add(head);
            } //list will always have pointer to its head
        }

        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(!pq.isEmpty())
        {
            ListNode currMin=pq.poll();
            curr.next=currMin;
            curr=curr.next;
            if(currMin.next!=null)//list has elements , has them in PQ
            {
                pq.add(currMin.next);//PQ will heapify and will keep smallest elment at top/head
            }
        }
        return dummy.next;//head of merged list, dummy is first node
    }
}