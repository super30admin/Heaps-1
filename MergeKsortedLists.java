// Time Complexity : O(nlogk) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
      PriorityQueue<ListNode> minHeap=new PriorityQueue<ListNode>(new pqComparator());
      for(ListNode list:lists){
          if(list!=null){
          minHeap.add(list);
      }
    }
        ListNode dummyHead= new ListNode(-1);
        ListNode head=dummyHead;
        while(!minHeap.isEmpty()){
          ListNode top=minHeap.remove();
          if(top.next!=null){
              minHeap.add(top.next);
          }
            head.next=top;
            head=head.next;
      }
        return dummyHead.next;
        
    }
}

class pqComparator implements Comparator<ListNode>{
    public int compare(ListNode s1,ListNode s2){
        if(s1.val>s2.val){
            return 1;
        }
        else if(s1.val<s2.val){
            return -1;
        }
        return 0;
    }
}