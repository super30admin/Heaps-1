// Time Complexity : O(NK log(K))
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Push all the heads of the lists into minheap of k size.
// Then extract min, move the pointer to next of the list and keep comparing until heap is empty.
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
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null || lists.length==0) return null;
        
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        
        
        for(ListNode list:lists)
        {
            if(list!=null)
                pq.add(list);
        }
        
        while(!pq.isEmpty())
        {
             
            ListNode node=pq.poll();
            curr.next=node;
            if(node.next!=null)
                pq.add(node.next);
            curr=curr.next;
            
        }
        
        return dummy.next;
        
    }
}