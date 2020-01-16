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
Time Complexity : O(nlogn) n: number of elements and k: number of lists

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
            ListNode temp = node;
            while(temp != null){
                pq.add(temp);
                temp = temp.next;
            }
        }
    
        results = new ListNode(0);
        ListNode head = results;
        while(!pq.isEmpty()){
            ListNode t = new ListNode(pq.poll().val);
            results.next = t;
            results = results.next;
        }  
        return head.next;
    }
}
