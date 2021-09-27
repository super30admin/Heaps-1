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
// Time Complexity: O(n*klog(n)) processing through k lists with n elements using heap(putting in heap) - log(n)
// Space Complexity: O(k) k elements kept in queue at a time
// Write your approach here
// Idea here is to take first node of each list put it in a min heap
// poll lowest element and push that element's next node to heap because it may contain a value lesser than rest of the lowest values of each list
// continue to do so until heap runs out of elements
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode li: lists) {
            if(li!=null){
                pq.add(li);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}