// time: O(nlogn)
// Space: O(n)


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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b)-> a.val- b.val);
        for(ListNode node: lists){
            ListNode cur = node;
            while(cur!=null){
                pq.add(cur);
                cur =cur.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            
            temp.next =  pq.poll();
            temp = temp.next;
        }

        temp.next = null;

        return dummy.next;

    }

    
}