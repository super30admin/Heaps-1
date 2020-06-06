#Time Complexity : O(nkLogk) where N is number of nodes in sorted list and k is the number 
#of lists to merge and logk for hepify

# Space Complexity : O(nK) where K is number of lists

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
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val -b.val);
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        for (ListNode head:lists)
        {
            if (head != null)
            {
            pq.add(head);
            }
        }
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if (min.next != null)
            {
                pq.add(min.next);
            }
            
        }
        return result.next;
    }
}
            
========================================================================================BruteForce
#Time Complexity : O(nk*k) where N is number of nodes in sorted list and k is the number 
#of lists to merge and k for interation through the lists

# Space Complexity : O(1)
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
        if (lists == null || lists.length == 0)
            return null;
        
        ListNode mergelist = new ListNode(Integer.MIN_VALUE);
        ListNode result = mergelist;
        for (ListNode l1:lists)
        {
            mergelist = merge(mergelist,l1);
        }
        return result.next;
    }
    private ListNode merge(ListNode l1, ListNode l2)
        {
            if (l1== null) return l2;
            if (l2 == null) return l1;
            ListNode result = new ListNode(Integer.MIN_VALUE);
            ListNode curr = result;
            while(l1 !=null && l2 !=null)
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
            if (l1 == null)
            {
                curr.next = l2;
            }
            if (l2 == null)
            {
                curr.next = l1;
            }
            return result;
        }
}
