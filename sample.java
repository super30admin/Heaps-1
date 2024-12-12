//Time Complexity: O(nLog(k)
//Space Complexity: O(n)
// Solution for https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    /* Min Heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int j =0;
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }*/
    // Max Heap
     public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        int j =0;
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>(n-k))
                result = Math.min(pq.poll(),result);
        }
        return result;
    }
}
// Solution for https://leetcode.com/problems/merge-k-sorted-lists/
TC:O(NLog(k) where k is the number of lists
SC: O(N)
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode head: lists)
        {
            if(head!=null)
            {
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty())
        {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next!=null)
            {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
