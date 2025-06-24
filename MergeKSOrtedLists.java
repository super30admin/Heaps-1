/*
 * TC: O(n*k*logk), n: avg size of elements in list, k is no of list given.
 * SC: O(k), k: no of list.
 * 
 * Approach: Using min heap, i will create Priority Queue which will have min ListNode on the top.Initially i add one node of all the list into my queue then,  each time i remove the min i will move the pointer of the lIstNOde to the next ad keep doing it 
 * for all the list. Do the same until Queue is empty.
 */
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
        int size = lists.length;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> (a.val - b.val));
        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        for(ListNode li : lists){
            if(li != null) q.add(li);
        }

        while(!q.isEmpty()){
            ListNode curr = q.poll();
            dummy.next = curr;
            dummy = dummy.next;

            if(curr.next != null)  q.add(curr.next);
        }
     return result.next;
    }
}