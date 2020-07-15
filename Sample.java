// Time Complexity : O(nlogk) as we iterate the array of n and for heapify it takes log k time
// Space Complexity : O(k) heap size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // default min heap
        for (int i = 0; i < nums.length; i++) { // iterate through the array
            pq.add(nums[i]); // add to the heap
            if (pq.size() > k) // if the size exceeds k we pop, and heapfiy happens and min element comes at
                               // top
                pq.poll();
        }
        // at the end we have kth largest element remaining (as k-1 elements smaller are
        // removed)
        return pq.poll();
    }
}

// Time Complexity : O(nlog(n-k)) as we iterate the array of n and for heapify
// it takes log n-k time
// Space Complexity : O(n-k) heap size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE; // store the min out of the elements popped
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // max heap
        for (int i = 0; i < nums.length; i++) { // iterate over the array
            pq.add(nums[i]); // add to heap
            if (pq.size() > nums.length - k) { // if size exceeds n-k

                min = Math.min(min, pq.poll()); // we pop from the heap the max element at top and compare with previous
                                                // min as we want min out of popped elements
            }

        }

        return min;
    }
}

// Time Complexity : O(nklog k) where nk is total number of elements in result
// and log k is time to heapify k list nodes
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val); // min heap on value of listnodes
        ListNode dummy = new ListNode(-1); // to create the new linkedlist...we will be moving this pointer
        ListNode result = dummy; // to keep track of the start of new list

        for (ListNode list : lists) { // iterate through the lists
            if (list != null) // if list is there
                pq.add(list); // add the first node
        }

        while (!pq.isEmpty()) { // till heap becomes empty
            ListNode min = pq.poll(); // get the min value from top of the heap
            dummy.next = min; // point dummy's next to min node created
            dummy = dummy.next; // move dummy to its next

            if (min.next != null) { // if the list from which min was taken has more elements
                min = min.next; // move min to min next
                pq.add(min); // add it to queue
            }
        }

        return result.next;
    }
}

// Time Complexity : O(k^2 * n ) as we merge k lists having elements nk
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) // edge case
            return null;

        ListNode mergedList = new ListNode(Integer.MIN_VALUE); // dummy with min value so that it stays in the front of
                                                               // list
        ListNode result = mergedList; // to keep track of the start of new list

        for (ListNode list : lists) { // call merge on mergedlist till now and list
            mergedList = merge(mergedList, list);
        }

        return result.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while (l1 != null && l2 != null) { // till one of the list ends
            if (l1.val < l2.val) { // if l1 is smaller
                dummy.next = l1; // point dummy to l1
                l1 = l1.next; // move l1
            } else {
                dummy.next = l2; // else point dummy to l2
                l2 = l2.next; // move l2
            }

            dummy = dummy.next; // move dummy each time
        }

        if (l1 != null) // if l1 has elements remaining
            dummy.next = l1; // point dummy to l1 list

        if (l2 != null) // if l2 has elements remaining
            dummy.next = l2; // point dummy to l2 list

        return result.next;
    }
}