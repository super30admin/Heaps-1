// Time Complexity : get operation -> O(Nlogk) k is the number of lists
// Space Complexity : O(k) from the size of the heap
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
      
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new comparator());
      
        for(ListNode list : lists)
        {
          if(list != null)
          {
            heap.add(list);
          }
        }
      
        ListNode dummy = new ListNode(-1);
      
        ListNode current = dummy;
      
        while(!heap.isEmpty())
        {
          ListNode top = heap.remove();
          
          if(top.next!=null)
          {
            heap.add(top.next);
          }
          
          current.next = top;
          current = top;
        }
      return dummy.next;
    }
  
    public class comparator implements Comparator<ListNode> 
    {
        public int compare(ListNode l1, ListNode l2)
        {
            if(l1.val > l2.val)
            {
                return 1;
            }
            else if(l1.val < l2.val)
            {
                return -1;
            }
            return 0;
        }
    }
}