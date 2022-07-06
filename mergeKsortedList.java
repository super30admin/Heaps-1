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

//Passed test cases on LeetCode

class Solution {
    //O(Nlogk) - Time complexity where logk is the time for building a priorityQueue with k nodes in it and N represents the total number of elements
    //O(n) - Space complexity 
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head:lists)
        {
            if (head != null)
            {
                pq.add(head);
                System.out.println(head.val);
            }
        }
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null)
                pq.add(min.next);
        }
        return res.next;
        
    }
}