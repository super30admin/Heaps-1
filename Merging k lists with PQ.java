// Time complexity - O(nlogK)
//space complexity - 0(K)
// Code successfully executed on leetcode



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode merged = new ListNode(-1);
        ListNode result = merged;
        PriorityQueue <ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
            while(!pq.isEmpty()){
                ListNode min = pq.poll();
                merged.next = min;
                merged = merged.next;
                if(min.next!=null){
                    pq.add(min.next);
                }
            }
        return result.next;
    }
}
        