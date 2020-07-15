// Time Complexity : O(nlogk) where k is average number of lists
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes		
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists ==  null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1,null);
        ListNode cur = dummy;
        for(ListNode node : lists){
            if(node!=null)
              pq.add(node);
        }
        
        while(!pq.isEmpty()){
            
              ListNode min = pq.poll();
              cur.next = min;
              cur  = cur.next;
              if(min.next != null){
                  min = min.next;
                  pq.add(min);
              }
        }
        
        return dummy.next;
    }
}