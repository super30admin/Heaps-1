using System;
using static Algorithms.Linked_List_Reverse;

namespace Algorithms
{
    public class MergeKLists
    {
        /// Time Complexity : O(nkLogk) 
        // Space Complexity :O(k)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public ListNode mergeKLists(ListNode[] lists)
        {
            PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b)->a.val - b.val);
            ListNode result = new ListNode(-1);
            for (ListNode head : lists)
            {
                if (head != null)
                {
                    pq.add(head);
                }

            }
            ListNode curr = result;
            while (!pq.isEmpty())
            {
                ListNode min = pq.poll();
                curr.next = min;
                curr = curr.next;
                if (min.next != null)
                {
                    pq.add(min.next);
                }
            }

            return result.next;
        }
    }
}
