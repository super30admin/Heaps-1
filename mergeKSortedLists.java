// Time Complexity : O(Nlogk) N - number of nodes in the final list, k = number of lists
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

///// HEAP APPROACH //////
// Maintain a min heap and keep on adding all the elements from all the lists to the min heap
// Create a new list by iterating the min heap and removing the top elements and adding them to the result list till the min heap is empty


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
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(ListNode l: lists) {
            while(l!=null) {
                minHeap.add(l.val);
                l = l.next;
            }
        }
        
        while(minHeap.size() > 0) {
            curr.next = new ListNode(minHeap.remove());
            curr = curr.next;
        }
        
        return dummy.next;
    }
}   
  
