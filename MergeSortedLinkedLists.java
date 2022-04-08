/**
 * space O(1) - no extra space is allocated except for the pq which contains pointers to listnodes
 * time complexity is k*n (k*logk) - k is number of lists and n is elements in each list
 */
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val-b.val));
        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        
        while(!pq.isEmpty()) {
            ListNode node = pq.remove();
            if(node.next != null) {
                pq.add(node.next);
            }
            iter.next = node;
            iter = iter.next;
        }
        return dummy.next;
    }
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}