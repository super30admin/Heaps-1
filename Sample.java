## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

// Time Complexity - 0(n log k)
// Space Complexity - 0(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}


## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity - 0(nk logk)
// Space Complexity - 0(k)


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next != null) {
                pq.add(min.next);
            }
            curr = curr.next;
        }
        return dummy.next;        
    }
}