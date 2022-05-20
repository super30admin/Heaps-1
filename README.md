# Heaps-1

## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

class Solution {
    
    //TC (n) SC O(1)
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}

## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

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
    //TC O(nklogn) SC O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        
        for(ListNode head: lists){
            if(head!= null){
            pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
    return dummy.next;
    
    }
    
}
