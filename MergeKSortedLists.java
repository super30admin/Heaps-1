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
         PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
         for(ListNode head: lists)
         {
            if(head!=null)
            {
                pq.add(head);
            }
         }
         ListNode dummy = new ListNode(-1);
         ListNode cur = dummy;
         while(!pq.isEmpty())
         {
            ListNode minNode = pq.poll();//logk
            cur.next = minNode;
            cur = cur.next;
            if(minNode.next !=null)
            {
                pq.add(minNode.next);
            }
         }
         return dummy.next;
    }
}

//tc:NlogK
//k is the no of lists
//sc: O(k)