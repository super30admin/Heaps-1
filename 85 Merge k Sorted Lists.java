// Time Complexity : O(nlogk)
// Space Complexity :O(n+k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);

        for (ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if (currMin.next != null) {
                pq.add(currMin.next);
            }
        }
        return dummy.next;
    }
}