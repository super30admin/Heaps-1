using System;
using System.Collections.Generic;
using System.Text;

namespace Heap
{
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int val = 0, ListNode next = null)
        {
            this.val = val;
            this.next = next;
        }
    }
    public class MergeKSortedList
    {
        /*
         * T.C: O(nkLognk) where n is avg no of items in each list and k is no of lists
         * S.C: O(nk) 
         * 
         */
        public ListNode MergeKLists(ListNode[] lists)
        {
            if (lists == null || lists.Length == 0) return null;

            Console.WriteLine(lists.Length);

            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            PriorityQueue<ListNode, int> queue = new PriorityQueue<ListNode, int>();

            foreach (ListNode head in lists)
            {
                if (head != null)
                {
                    queue.Enqueue(head, head.val);
                }
            }

            while (queue.Count != 0)
            {
                ListNode min = queue.Dequeue();

                curr.next = min;
                curr = curr.next;
                if (min.next != null)
                {
                    queue.Enqueue(min.next, min.next.val);
                }

            }

            return dummy.next;
        }
    }
}
