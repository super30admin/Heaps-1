
//Time complexity: O(nlogk) where n is the total elements and k is the number of lists
//Space complexity: O(k) for the heap


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
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums){
            minHeap.add(num);
            
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        return minHeap.peek();
    }
}