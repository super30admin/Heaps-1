/**
 * Time: O(nklogk) n-average length of each list and k-length of the input array lists
 * Space: O(nk) create new list + (prioirtyqueue - O(k))
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1,l2)->l1.val-l2.val);
        int k = lists.length;
        ListNode l3 = new ListNode(0);
        ListNode head = l3;

        for(int i=0;i<k;i++){
            pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode ln = pq.poll();
            l3.next = new ListNode(ln.val);
            l3 = l3.next;
            ln = ln.next;
            if(ln!=null)
                pq.add(ln);
        }
        return head.next;
    }
}