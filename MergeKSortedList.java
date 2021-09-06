/* Time Complexity : O(nklogk) where k is no of lists and n is no of elements in each list 
   Space Complexity :   O(k)
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
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head : lists){
            if(head!=null){
            pq.add(head);
            head=head.next;
            }
        }
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode cur = res;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if(temp.next!=null){
            temp=temp.next;
            pq.add(temp);
            }

        }
        return res.next;
    }
} 