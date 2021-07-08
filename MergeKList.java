//Time Complexity - O(nklogk)
//Space Complexity - O(nk)


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
      PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
      ListNode dummyNode = new ListNode(-1);
      ListNode currentNode = dummyNode;
      for(ListNode head: lists) {
        if(head != null) {
          pq.add(head);
          
        }
      }
      while(!pq.isEmpty()) {
        ListNode minNode = pq.poll(); // get the top min element
        //add it to the resultant listNode
        currentNode.next = minNode;
        currentNode = currentNode.next;
        if(minNode.next != null) { // add next element from the list 
          pq.add(minNode.next);
        }
      }
        return dummyNode.next;
        
    }
}