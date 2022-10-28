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
// TC : O(nklognk) -> n - number elements in each list, k number of lists
// SC : O(k)
// Min heap solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        
        for(ListNode lst : lists) {
            if(lst != null)
                pq.add(lst);
        }
        
        ListNode cur = dummy;
        
        while(!pq.isEmpty()) {
                ListNode temp = pq.poll();
                cur.next = temp;
                cur = temp;
                temp = temp.next;
                if(temp != null)
                    pq.add(temp);            
        }
        return dummy.next;
    }
}
