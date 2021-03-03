/**
Time: O(nk log(k)) 
Space: O(k)

where n = no of node in a list; k = no of lists

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
        //edge case
        if(lists.length == 0) return null;
        
        //create a min Heap as we need to maintain only min elements from each list
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head : lists){
            pq.add(head);
        }
        
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            
            //add the next node of the removed node in the pq 
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}