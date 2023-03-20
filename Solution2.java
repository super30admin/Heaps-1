// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I create a minHeap of type ListNode and add all the nodes in lists to it. I create a dummy node sorted and set head to sorted.
 * I now iterate through the minHeap until it's size is zero, I poll the minimum node and make sorted.next to point to it. I add the
 * polled node's next node to the minHeap and continue this process till all nodes are popped out of the heap. In the end, I return 
 * head.next.
 */

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
        if(lists==null || lists.length==0)
        {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode sorted = new ListNode(-1);
        ListNode head = sorted;
        for(ListNode temp : lists)
        {
            if(temp!=null)
            {
                minHeap.add(temp);
            }
        }
        while(!minHeap.isEmpty())
        {
            ListNode temp = minHeap.poll();
            sorted.next=temp;
            if(temp.next!=null)
            {
                minHeap.add(temp.next);
            }
            sorted = sorted.next;
            temp.next=null;
        }
        return head.next;
    }
}