// Time Complexity : o(nk logk)
// Space Complexity : o(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Initialize a priority queue to store the head of each linked list and use a dummy node to build the result list.
//Continuously extract the minimum node from the queue, add it to the result list, and push its next node to the queue if it exists.
//The merged result list will start from the next node of the dummy node.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!= null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}