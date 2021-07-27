// Time Complexity: O(Nlogk) where k is the number of lists and N is the total number of elements in k lists
// Space Complexity: O(k)
// Run on Leetcode: yes
// Issues faced: none

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if(lists == null || lists.length == 0)
            return dummy.next;
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode n: lists){
            if(n != null)
                pq.add(n);
        }
        
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null)
                pq.add(curr.next);
        }
        
        return dummy.next;
    }
}
