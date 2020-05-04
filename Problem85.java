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
/**
 * Time Complexity - O(n log n)  m = number of listnodes
 * Space Complexity - O(n)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode head = new ListNode(-1);
        ListNode first = head;
        for(ListNode list : lists){
            if(list != null){
                queue.add(list);
            }
        }

        while(!queue.isEmpty()){
            head.next = queue.poll();
            head = head.next;
            if(head.next != null){
                queue.add(head.next);
            }
        }
        return first.next;
    }
}