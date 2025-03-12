// time complexity - O(nlogk) n = max length of list, k = number of lists
// space complexity - O(k) k = number of lists
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
public class Solution
{
    public ListNode MergeKLists(ListNode[] lists)
    {
        PriorityQueue<ListNode, int> pq = new PriorityQueue<ListNode, int>();
        foreach (ListNode head in lists)
        {
            if (head != null)
            {
                pq.Enqueue(head, head.val);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (pq.Count > 0)
        {
            ListNode min = pq.Dequeue();
            curr.next = min;
            curr = curr.next;
            if (min.next != null)
            {
                pq.Enqueue(min.next, min.next.val);
            }
        }
        return dummy.next;
    }
}