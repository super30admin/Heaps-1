//Time complexity: O(Nlogk), where N is the total number of nodes in the final list and k is the number of lists.
//Space complexity: O(k)

import java.util.*;

class Solution2 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val; 
            }
        });
            
        ListNode dummyHead = new ListNode(-1); 
        ListNode newNode = dummyHead; 
        
        for(ListNode node: lists) {
            if(node!=null) {
                pq.offer(node); 
            }
        }
        
        while(!pq.isEmpty()) {
            ListNode current = pq.poll(); 
            newNode.next = current; 
            newNode = newNode.next; 
            if(current.next != null) {
                pq.offer(current.next); 
            }
        }
        
        return dummyHead.next; 
    }
}