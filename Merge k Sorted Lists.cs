/*
  Time complexity: O(n*k*log k)
  Space complexity: O(k)

  Code ran successfully on Leetcode: Yes
*/

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
        PriorityQueue<ListNode,int> pq = new();
        ListNode result = new ListNode(int.MinValue);
        ListNode current = result;

        foreach(var head in lists)
        {
            if(head!=null)
                pq.Enqueue(head, head.val);
        }

        while(pq.Count>0)
        {
            ListNode temp = pq.Dequeue();
            if(temp.next!=null)
                pq.Enqueue(temp.next,temp.next.val);

            current.next = temp;
            current = current.next;
        }
        return result.next;
    }
}
