//Time complexity:- O(n log k) where k = size of heap
//Space complexity:- O(k)

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
        
        //we will add all the list nodes in the min heap, the one which is smallest will be popped first and added to resultant linked list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> (a.val - b.val));

        //Add starting nodes of all the list in the min heap
        for(ListNode l: lists) {
            
            if(l != null)
                minHeap.add(l);
        }

        //we will add nodes into this resultant list
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while(!minHeap.isEmpty()) {
    
            //since min heap top element is always the smallest, pop it and add to result
            ListNode node = minHeap.poll();

            //we will add the next element to heap
            if(node.next != null)
                minHeap.add(node.next);

            result.next = node;
            result = node;
        }

        return dummy.next;
    }
}

