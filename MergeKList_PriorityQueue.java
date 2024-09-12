/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 
 * Time Complexity : O(nlog k) where n is total number of elements in all the lists
 * Space Complexity : O(k)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null)
                queue.add(list);    
        }
        
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            dummy.next = temp;
            dummy = dummy.next;
            
            if(temp.next != null){
                queue.add(temp.next);
            }
        }
        
        return result.next;
        
    }
}