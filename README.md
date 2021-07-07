# Heaps-1

## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

## Max Heap Solution 
// Keep the queue size to n-k and keep removing the largest element and adding it to the result
## Time Complexity = nlog(n-k)
## Space Complexity = log(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); 
        int result = Integer.MAX_VALUE;
        for(int num : nums){
            pq.add(num);
            
            if(pq.size() > nums.length - k){
                result = Math.min(result, pq.poll()); 
            }
        }
        return result; 
    }
}

## Min Heap Solution 
// Keep the queue size to k and keep removing the smallest element from the queue
## Time Complexity = nlog(k)
## Space Complexity = log(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int num : nums){
            pq.add(num);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek(); 
    }
}

## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

## Time Complexity = nk*log(k)
## Space Complexity = log(k)
//Add the head of the list to the queue and then keep of adding the next node of the min
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy; 
        
        for(ListNode head:lists){
            if(head != null){
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