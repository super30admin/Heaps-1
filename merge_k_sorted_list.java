// Time Complexity : O(nklog(k)), where k is the number of lists and n is the size of each list
// Space Complexity : O(k), where k is the number of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//1. Create a priority queue and add heads of all the k list
//2. remove the top head and add it to the new list. move the polled head to its next node and put in the priority queue
//3. Keep doing the till the priority queue becomes empty and the return the head of the new list

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
        //edge case
        if(lists.length == 0) return null;
        
        //dummy node to hold the new merged sorted list
        ListNode dummy = new ListNode();
        //create a priority queue (min heap) to sort the k lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        
        //add the heads of the k lists in the priority queue, if not null
        for(ListNode head: lists){
            if(head != null)
            pq.add(head);
        }
        //creating a temp reference of the dummy node
        ListNode curr = dummy;
        //start forming the new list by polling one minimum from the priority queue and then pushing the next node of the current minimum node in the priority queue
        //keep doing this till the priority queue becomes empty
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            //add this temp to the new list
            curr.next = temp;
            //move the curr to temp
            curr = curr.next;
            //forward the temp to its next and add it to the priority queue if temp is not null
            temp = temp.next;
            if(temp != null){
                pq.add(temp);
            }
        }
        //dummy holds the new merged sorted list
        return dummy.next;
    }
}