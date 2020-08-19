// Time Complexity : O(Nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //base case
        if(lists == null || lists.length == 0)
            return null;
        
        //custom comparator
        Comparator<ListNode> customComparator = new Comparator<>(){
            public int compare(ListNode a, ListNode b){
                return a.val-b.val; //natural ordering
            }
        };
            
        //Create PQ with customComparator    
        PriorityQueue<ListNode> minHeap = new PriorityQueue(customComparator);
            
        //Add all head nodes
        for(ListNode headNode : lists)
        {
            if(headNode != null)minHeap.add(headNode);
        }
            
        //Result
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        
        //Iterate
        //get minNode, insert its next
        while(!minHeap.isEmpty())
        {
            ListNode minNode=minHeap.poll();
            cursor.next=minNode;
            cursor=minNode;
            if(minNode.next != null)
                minHeap.add(minNode.next);
        }
       return result.next; 
    }
}
