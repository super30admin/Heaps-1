// Time Complexity : Approach 1: O(nk log k); Approach 2 L O(nk^2) where n is number of nodes in a linked lists and k is number of linked lists
// Space Complexity : O(1) for both the approach 2 and O(k) for approach 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: In Approach 1, use a priority Queue (min heap), where you put the list nodes one by one
from each of the lists starting from the first nodes of all the k lists. The node with the minimium will appear at the top of the queue, fetch that
and check which lists that the min node belongs too, and put in its next node of the minimum. Repeat the steps till all the nodes have been set
into priority queue is emptied. In Approach 2, merge the first two lists. Then continue merging the next lists and the already merged list till now
one by one. At the end, you will get a merged list that has all the nodes.
*/
// APPROACH 1:  USING PRIORITY QUEUE
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){return null;}
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);           // Min heap for ascending order
        for(ListNode node: lists){
            if(node != null)            
                pq.add(node);                                                               // Add all the first nodes of the k lists
        }
        while(!pq.isEmpty()){                                                               // Repeat till all the nodes have been covered in the k lists
            ListNode min = pq.poll();                                                       // fetch the minimum value node
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null)                                
                pq.add(min.next);                                                           // Get the next node of the min value node
        }
        return result.next;
    }
}

// APPROACH 2: USING MERGING METHOD
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){return null;}
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        for(ListNode node : lists){
            dummy = merge(dummy, node);                                                     // Start the merging process with the inital two lists
        }
        return result.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){return l2;}
        if(l2 ==  null){return l1;}
        ListNode curr = new ListNode(Integer.MIN_VALUE);                                        // need to display the full LL
        ListNode head = curr;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){                                                            // join current with the lower value node
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;                             
                l2 = l2.next;
            }
            curr = curr.next;                                                               // current will move to the next at every step
        }
        if(l1 == null) {
            curr.next = l2;                                                             // Once the other list finishes, join the remaining of l2 to current
        }
        if(l2 == null){
            curr.next = l1;                                                             // join the remaining of l1 to current
        }
        return head.next;                                                               // Return the merged list till now to merge with the next of the upcoming remaining lists
    }
}