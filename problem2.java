// Time Complexity : O(nklogk)
// Space Complexity :O(nk)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

/* Approach
 * we are using heaps to sort the element for us, ((a,b) -> a.val - b.val) because this is a ListNode
 * queue we are tell the comprator how to compare the value
 * 
 * first we add all the first elements of all the lists in a queue
 * then we create a new list to store the orderted value
 * we start a while loop until it queue is empty
 * we remove the root of the heap(first ele of the queue) as it will be the smallest 
 * add that to our need list and take the next node that it was pointing to and add it to the queue if it
 * is not empty
 * 
 * return dummy.next
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}