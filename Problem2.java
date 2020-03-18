/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        Comparator<ListNode> cmp = new Comparator<>() {

            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };

        PriorityQueue<ListNode> pq = new PriorityQueue(cmp);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode sol = new ListNode(0);
        ListNode cursor = sol;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            cursor.next = min;
            cursor = min;
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return sol.next;

    }
}