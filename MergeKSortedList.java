/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*Time Complexity : 
Space Complexity : the priority queue (often implemented with heaps) costs O(k) which is nothing or far less than total elements in all the linkedlist.
Appraoch:
1. Brute force: traverse all linked list save all the values in an array sort them and again create a new linked list from those values. Time- O(nlogn)  space O(n)
3. Optimized approach using Priority Queue: 
Time Complexity: O(nlogk)
The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue as I would be having the heap of size k and as are N nodes in the final linked list.
finding the node with the smallest value just costs O(1) time. 


*/
class Solution {
    PriorityQueue<ListNode> pq;
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        
       pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        for(ListNode list: lists){
            if(list != null)
                pq.add(list);
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode ptr= dummyNode;
        
        while(!pq.isEmpty()){
            ListNode node =  pq.remove();
            ptr.next = node;
            ptr= ptr.next;
            if(node.next!=null)
                pq.add(node.next);
        }
        return dummyNode.next;
    }
}
