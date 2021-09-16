using System;
using System.Collections.Generic;
using System.Text;

namespace Heaps
{
    class MergeKSortedListsLL
    {
        public class ListNode
        {
            internal int val;
            internal ListNode next;
            ListNode() { }
            internal ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        //TC: O(n * k^2)
        //SC: O(1)
        public ListNode MergeLists(ListNode[] lists)
        {
            if (lists == null || lists.Length == 0)
            {
                return null;
            }
            ListNode merged = new ListNode(Int32.MinValue);
            foreach (ListNode list in lists)
            {
                merged = merger(merged, list);
            }
            return merged.next;
        }

        private ListNode merger(ListNode l1, ListNode l2)
        {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (l1 != null && l2 != null)
            {
                if (l1.val < l2.val)
                {
                    curr.next = l1;
                    l1 = l1.next;
                }
                else
                {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 != null)
            {
                curr.next = l1;
            }
            if (l2 != null)
            {
                curr.next = l2;
            }
            return dummy.next;
        }
    }
}
