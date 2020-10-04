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
// Time Complexity : On(logk) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(new pqComparator());
        
        for(ListNode list: lists){
            if(list!=null){
                minheap.add(list);
            }
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        
        while(!minheap.isEmpty()){
            ListNode top = minheap.poll();
            if(top.next!=null){
                minheap.add(top.next);
            }
                head.next=top;
                head=head.next;
        }
        return dummyHead.next;
    }
    
class pqComparator implements Comparator<ListNode>{

    public int compare(ListNode l1, ListNode l2){
        if(l1.val> l2.val){
            return 1;
        }else if(l2.val > l1.val){
            return -1;
        }else
            return 0;
    }
}
}