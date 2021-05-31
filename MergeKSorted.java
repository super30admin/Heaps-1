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

// Time Complexity :  O(KlogN) because for adding one element is log N and there are K lists so O(KlogN) 
// Space Complexity : O(K) for adding all elements of all lists into PriorityQueue.
// Did this code successfully run on Leetcode : Yes

class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode result = new ListNode();
        ListNode curr=result;
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2); // Small to large
        
        for(ListNode ls : lists){ // Iterate over entire list and add all elements to priority queue
            
            while(ls!=null){
                
                pq.add(ls.val);
                ls=ls.next;
            }
            
        }
        
        while(!pq.isEmpty()){ // Start popping out elements one by one and add to linked list
            
            ListNode temp= new ListNode(pq.poll());
            curr.next=temp;
            curr=curr.next;
        }
        
        
        
        return result.next; 
    }
}