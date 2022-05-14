//TC = O(nk Log nk) where k = total no of lists and n = avg numbers in each list
//SC = O(nk)

import java.util.*;
public class MergeKSortedLists {

    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val)
        {
            this.val  = val;
        }

        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        
        for(ListNode head : lists)
        {
            if(head!=null)
            {
                 pq.add(head);
            }
        }
        
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            
            if(min.next != null)
            {
                pq.add(min.next);
            }
        }
        
        return dummy.next;
        
    }
}
