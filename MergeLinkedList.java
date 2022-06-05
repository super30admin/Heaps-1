// Time Complexity : O(k *n *log k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.PriorityQueue;

public class MergeLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head != null){
                queue.add(head);
            }
        }
        ListNode result = new ListNode();
        ListNode curr = result;
        while(! queue.isEmpty()){
            ListNode min = queue.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null) queue.add(min.next);
        }
        return result.next;
    }
}
