// TC: avg number of elements in one list = n and totally k lists.
// looping over all elements and having Q size as k. So O(nk log(k))
// SC: O(k)

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
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            if (list.next != null) {
                pq.add(list.next);
            }
            cur.next = list;
            cur = cur.next;
        }

        return dummy.next;        
    }
}