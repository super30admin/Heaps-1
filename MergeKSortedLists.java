// Time Complexity: O(Nlogk) where N is total number of elements and k is the number of lists
// Space Complexity: O(k) where k is the number of lists
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
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for(ListNode list: lists){
            if(list != null){
                pq.offer(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode elem = pq.poll();
            dummy.next = elem;
            elem = elem.next;
            dummy = dummy.next;

            if(elem != null){
                pq.offer(elem);
            }
        }
        return head.next;
    }
}
