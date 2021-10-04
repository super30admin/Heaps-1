// Time Complexity : O(NKLogK) iterating through the array with K listnodes having average N nodes and inserting K nodes in min heap at a time
// Space Complexity : O(K) in the min heap we are storing max k elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Three line explanation of solution in plain english: Put 1st element of each list in min heap this limits the size of priority queue or min heap to K. Pop the min element and put its next element in the min heap and add the popped min element in the result list.

// Your code here along with comments explaining your approach

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
        ListNode result = new ListNode();
        ListNode curr = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        //null cases
        if(lists == null || lists.length == 0)
            return result.next;

        //iterate array of linked list and put the 1st node of each list in pq
        //this sets the pq to have just k (num of lists) in it
        for(ListNode ln: lists){
            if(ln != null){
                pq.add(ln);
            }
        }

        //Now while the pq is Empty poll the elements and add its next element to the pq and add the polled element to the result list.
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            if(min.next != null){
                pq.add(min.next);
            }
            curr.next = min;
            curr = curr.next;
        }
        return result.next;
    }
}