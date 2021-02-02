// Time Complexity : O(nk log k), n = max length of list, k = number of lists
// Space Complexity : O(k), k = number of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Maintain a Min Heap of size k, add the min element via poll() to the result and add the next node of this min node, while PriorityQueue is not empty.  

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode node : lists){
            if(node != null)
              q.add(node);
        }
        
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode result = dummy;
        
        while( !q.isEmpty()){
            ListNode curr = q.poll();
            
            if(curr.next != null){
                q.add(curr.next);
            }
            
            dummy.next = curr;
            dummy = dummy.next;
        }
        
        return result.next;
    }
}
