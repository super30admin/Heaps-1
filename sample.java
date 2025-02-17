//TC : O(nlogk)
//SC : O(k)

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
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode list:lists) {
            if (list != null){
                q.add(list);
            }
        }
        while (!q.isEmpty()) {
            ListNode min = q.poll();
            if (min.next != null) {
                q.add(min.next);
            }
            curr.next = min;
            curr = min;
        }
        return dummy.next;
    }
}


class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=0;i<nums.length;i++) {
            q.add(nums[i]);
            if (q.size() > k) {
                q.poll();
            } 
        }
        return q.peek();
    }
}
