// Time Complexity : O(N log K)
// Space Complexity : O(K)  for minheap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/merge-k-sorted-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode MergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode,int> minHeap = new PriorityQueue<ListNode,int>();

        foreach(ListNode list in lists){
            if(list != null){
                minHeap.Enqueue(list, list.val);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(minHeap.Count > 0){
            //Extract smallest node from th eheap
            ListNode currMin = minHeap.Dequeue();
            current.next = currMin;
            current = current.next;
            if(currMin.next!= null){
                minHeap.Enqueue(currMin.next,currMin.next.val);
            }

        }
        return dummy.next;
    }
}