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
// //Time: O(nklognk)
// //Space: O(nk)
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists == null || lists.length == 0)
//             return null;
//         ListNode merged = new ListNode(Integer.MIN_VALUE);
//         ListNode dummy = merged;
        
//         for(ListNode list: lists){
//             merged = merge(merged, list);
//         }
//         return merged.next;
        
//     }
    
//     private ListNode merge(ListNode l1, ListNode l2){
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         while(l1 != null && l2 != null){
//             if(l1.val < l2.val){
//                 curr.next = l1;
//                 l1 = l1.next;
//             }
//             else{
//                 curr.next = l2;
//                 l2 = l2.next;
//             }
//             curr = curr.next;
//         }
//         if(l1 != null){
//             curr.next = l1;
//         }
//         if(l2 != null){
//             curr.next = l2;
//         }
//         return dummy.next;
//     }
// }
//Time: O(nlogk)
//Space: O(nk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for(ListNode list: lists){
            if(list != null)
                pq.add(list);
        }
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}
