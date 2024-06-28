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
/*
//TC: O(nklogk) - n = avg no. of elements in a list ; k = no.of lists
//SC: O(k) - for heap
//We take head of all lists at add to PQ. Heapify happens and we keep adding the minimum min from the PQ to the next of the output list
//This way we keep on sorting it and appending it as next

class Solution {
     public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }

      return dummy.next;  
    }
}
