// TC: O(nklogk)
// SC:O(k)

// Approach:

// Pushed the heads of the list into min heap
// And then popped min head and added to ans list and then pushed the head->next into the heap until heap is empty

// Problem faced:
// Be careful about null checks while pushing

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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy= new ListNode();
        ListNode curr=dummy;

        PriorityQueue<ListNode>pq= new PriorityQueue<>((a,b)->a.val-b.val);
        
       for (ListNode i:lists) 
        {
            // ListNode num = lists[i];
            if(i!=null)
            pq.add(i); 
        }

        while(!pq.isEmpty())
        {
            ListNode temp=pq.poll();
            if(temp.next!=null)
            pq.add(temp.next);
            curr.next=temp;
            curr=curr.next;
        }

        return dummy.next;
        
    }
}
