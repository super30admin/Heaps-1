import java.util.PriorityQueue;

// Time Complexity :O(nlogk), where k is linked list
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understanding heaps

// Your code here along with comments explaining your approach

public class MergeKSortedList {
    /**
     * Definition for singly-linked list.
     **/
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            //loop over all list and add it to min heap, and advance node pointer
            for(ListNode head: lists){
                while(head != null){
                    minHeap.add(head.val);
                    head = head.next;
                }
            }

            //create new list from min heap
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while(!minHeap.isEmpty()){
                head.next = new ListNode(minHeap.remove());
                head = head.next;
            }
            return dummy.next;
        }
    }


}
