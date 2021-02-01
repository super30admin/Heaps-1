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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeComparator()); 
        for(ListNode list: lists){
            while(list!=null){
                pq.add(list);
                list = list.next;
            }
        }
        ListNode head = new ListNode();
        ListNode dummy = new ListNode();
        dummy = head;
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
        }
        head.next = null;

        return dummy.next;
    } 
  
class ListNodeComparator implements Comparator<ListNode>{ 
        public int compare(ListNode s1, ListNode s2) { 
           if (s1.val < s2.val) 
               return -1; 
           else if (s1.val > s2.val) 
               return 1;
           return 0; 
                } 
        } 
}

//Time complexity : O(n) where n is the number of all the elements
//Space complexity : O(n) to store all elements in a priority queue
 
