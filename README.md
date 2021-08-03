# Heaps-1

## Problem1

Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

//Time Complexity - O(NlogK)
// Space Complexity - O(K)

class Solution {
public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

}

## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

//Time Complexity - O(nKlogK)
// Space Complexity - O(nK)

/\*\*

- Definition for singly-linked list.
- public class ListNode {
-     int val;
-     ListNode next;
-     ListNode() {}
-     ListNode(int val) { this.val = val; }
-     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
- }
  \*/
  class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
  if(lists == null || lists.length == 0) {
  return null;
  }
  PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val-b.val));
  ListNode dummy = new ListNode(-1);
  ListNode result = dummy;

          for(ListNode head : lists) {
              if(head != null) {
                  queue.add(head);
                  //System.out.println(head.val);
              }
          }

          while(!queue.isEmpty()) {

              ListNode node = queue.poll();
              dummy.next = node;
              dummy = dummy.next;

              if(node.next!=null) {
                  queue.add(node.next);
              }
          }
          return result.next;
      }

  }
