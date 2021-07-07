
// Time Complexity : n log k. Where n is the number of nodes in given list. k is the number of list in the whole list. 
// Space Complexity : O(k) min heap holds k(Size of the list) element at any point of time.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        if(lists == null || lists.length == 0)
            return null;
        
        // Create a priority queue of size list 
        // Get the minimum element and add to resultant list
        // Maintain a dummy node for result head and append min nodes to dummy head and proceed from there.
        
        Comparator<ListNode> comparator = new Comparator<ListNode>(){ // As we need to compare 2 ListNodes we need custom comparator to evaluate nodes.  
            
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        };
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(comparator);
        
        ListNode result = new ListNode(-1); // Create a dummy node as head;
        ListNode cursor = result;  // Maintain cursor to mark the tail node. This is used to add to the resultant list than going over the entire list again and again
        
        // add all the head node from the lists 
        for(ListNode list : lists){
            if(list !=null){
                minHeap.add(list);    
            }
        }
      // result.next = minHeap.poll();
        
        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            
            // result.next = min;
            cursor.next  = min;
            cursor = min;
            if(min.next != null){ //Always validate if the next node is null before adding to min heap
                minHeap.add(min.next);
            }
            
        }
        
     return result.next;   
    }
}
