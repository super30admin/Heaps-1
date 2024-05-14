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
//Time Complexity : O(N log k), where k is the no of lists and N is the total no of elements in the lists
//Space Complexity : O(k)
//Did this code run successfully on leetcode: Yes
class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->a.val-b.val); 
       for(ListNode li : lists) {
            if(li != null)
                pq.add(li);
       }
       ListNode result = new ListNode(-1);
       ListNode curr = result;
       while(!pq.isEmpty()) {
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if(currMin.next != null) {
                pq.add(currMin.next);
            }
       }
       return result.next;

    }
}