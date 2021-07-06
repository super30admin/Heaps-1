import java.util.PriorityQueue;
// Time Complexity : O(nklogk) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
if there are k lists we are maintaing a min heap of size k.
for achieving the same, we have to pass a comparator to the priority queue of type  ListNode
we push the heads of all the lists in the pQueue, one with the least value would come at the top.
We can form a List by removing the least value and push the next node of that list in the pQueue.
Eventually we would be able to form a list by pulling out nodes with least values and moving ahead in those lists.
*/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        PriorityQueue<ListNode> pQueue=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        for(ListNode head:lists)
        {
            if(head!=null)
            pQueue.add(head);
            
        }
        while(!pQueue.isEmpty())
        {
            ListNode node=pQueue.poll();
            curr.next=node;
            if(node.next!=null)
                pQueue.add(node.next);
            curr=curr.next;
        }
        
        return dummy.next;
    }
}
