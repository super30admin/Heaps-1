// Problem 2 : Merge k Sorted Lists
// Time Complexity : O(n*k*log k) where n is the number of elements in the linked list and k is the number of the linked list
// Space Complexity : O(k) where k is the number of the linked list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
None
*/

// Your code here along with comments explaining your approach
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
        // Intialize the min heap which will hold the node and sort the element by the node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

        // Add the first nodes of all the list in the priority queue
        for(ListNode head:lists) {
            // check if the head is not null then add to priority queue
            if(head != null) {
                pq.add(head);
            }
        }
        // initialize dummy node
        ListNode dummyNode = new ListNode();
        // pointing current node to dummy node
        ListNode currentNode = dummyNode;
        // loop until priority queue is not empty
        while(!pq.isEmpty()) {
            // getting the smallest node 
            ListNode smallestNode = pq.poll();
            // if the smallest node has the next node then add it to priority queue
            if(smallestNode.next != null) {
                pq.add(smallestNode.next);
            }
            // set the next pointer of current node to smallest node
            currentNode.next = smallestNode;
            // move the current node to the next node
            currentNode = currentNode.next;
        }
        // return the next node of dummy node
        return dummyNode.next;
    }
}