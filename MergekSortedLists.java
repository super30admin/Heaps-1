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
//Time Complexity-O(logk)
//Space Complexity-O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pQueue=new PriorityQueue<ListNode>(new pqComparator());
            for(ListNode list:lists)
            {
                if(list!=null)
                {
                    pQueue.add(list);
                }
            }
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(!pQueue.isEmpty())
        {
            ListNode top=pQueue.remove();
            if(top.next!=null)
            {
                pQueue.add(top.next);
            }
            head.next=top;
            head=head.next;
        }
        return dummy.next;
        
    }
        
} 
class pqComparator implements Comparator<ListNode>{
        public int compare(ListNode s1,ListNode s2)
        {
            if(s1.val>s2.val)
            {
                return 1;
            }
            else if(s1.val<s2.val)
            {
                return -1;
            }
            return 0;
        }    
}
