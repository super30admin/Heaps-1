// Time Complexity :O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new heapcomp());
        ListNode dummy= new ListNode(-1);
        ListNode curr=dummy;
        
        for(ListNode list: lists){
            if(list!=null)
                heap.add(list);//add all first nodes of the lists
        }
        
            
            while(!heap.isEmpty()){
                ListNode top=heap.poll();//extract min from heap
                if(top.next!=null)
                    heap.add(top.next);
                curr.next=top;//add to dummy node
                curr=top;
                
                }   

    return dummy.next;
    }
    class heapcomp implements Comparator<ListNode>{//comparator to compare objects
        public int compare(ListNode n1, ListNode n2){
        if(n1.val>n2.val)
            return 1;
        else if(n1.val<n2.val)
            return -1;
         else
            return 0;
        }
        
    }
}