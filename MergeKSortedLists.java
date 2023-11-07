// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MergeKSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            ListNode result = new ListNode(-1);
            ListNode cur = result;

            for(ListNode list : lists){
                if(list != null)
                    pq.add(list);
            }

            while(!pq.isEmpty()){
                ListNode min = pq.poll();
                cur.next = min;
                cur = cur.next;
                if(min.next != null){
                    pq.add(min.next);
                }
            }

            return result.next;
        }
    }
}
