// Problem 1 - Kth Largest Element in an Array
// Time Complexity: O(log n) where, n = number of elements
// Space Complexity: O(k)

// Algorithm
// 1 - initialize priority queue
// 2 - loop over array
// 3 - add the number to priority queue
// 4 - if size exceeds k, then remove the smallest element
// 5 - return the kth largest which is priority queue's first elemnt
class Solution {
  public int findKthLargest(int[] nums, int k) {
    // 1
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 2
    for (int num : nums) {
      // 3
      pq.offer(num);
      // 4
      if (pq.size() > k) {
        pq.poll();
      }
    }
    // 5
    return pq.peek();
  }
}

// Problem 2 - Merge k Sorted Lists
// Time Complexity: O(log n)
// Space Complexity: O(1)

// Algorithm
// 1 - Initialize priority queue
// 2 - keep inserting listnode to priority queue
// 3 - prepare a listnode for result and return
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
    // 1
      PriorityQueue<Integer> pq = new PriorityQueue<>();

    // 2
      for(ListNode head:lists){
       while(head!=null) {
         pq.add(head.val);
         head=head.next;
       }
     }
    // 3
     ListNode dummy=new ListNode(-1);
     ListNode head=dummy;
     while(!pq.isEmpty()){
       head.next=new ListNode(pq.remove());
       head=head.next;
     }

     return dummy.next;
  }
}
