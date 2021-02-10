// Time Complexity : nlog(k) where n is total number of elements and k is the number of lists to be merged
// Space Complexity : O(k) where k is number of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MergeKSortedList {
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
        
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists)
        {
            if(head!=null) 
            pq.add(head);
        }
        
        while(!pq.isEmpty())
        {
            ListNode minNode = pq.poll();
            dummy.next = minNode;
            dummy = dummy.next;
            if(minNode.next!=null)
            {
                pq.add(minNode.next);
            }
        }
        return result.next;
    }
}
}
