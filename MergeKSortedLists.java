// Time Complexity : O(N) - As we traverse through all the sub lists in the list
// Space Complexity : O(N) - As we use a  priority queue data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        for(ListNode list : lists){
            while(list != null){
                queue.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode dummy1 = dummy;
        while(!queue.isEmpty()){
            ListNode point = new ListNode();
            point.val = queue.poll();
            dummy.next = point;
            dummy = dummy.next;
        }
        return dummy1.next;
    }
}
// Your code here along with comments explaining your approach