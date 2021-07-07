/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
LeetCode Submitted : YES
Space Complexity : O(number of elements in all lists)
Time Complexity : O(nlogk) n: number of elements and k: number of lists

The idea is to use min heap to preserve the oreder such that every parent is minimum then its children
**/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode results = null;
        
        if(lists == null || lists.length < 1)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            new Comparator<ListNode>(){
                public int compare(ListNode node1, ListNode node2){
                    return node1.val - node2.val;
                }
            });
        
        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }
        
        results = new ListNode(0);
        ListNode head = results;
        
        while(!pq.isEmpty()){
                ListNode temp = pq.poll();
                results.next = temp;
                temp = temp.next;
                results = results.next; 
            
                if(temp != null)
                    pq.add(temp);
        } 
        return head.next;
    }
}
