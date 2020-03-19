// Time Complexity : O(nlogk) n -> total no of elements; k -> no of lists
// Space Complexity : O(n) n -> total no of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach 1: using priority queue
// All the head nodes can be added in the priority queue in the beginning. In this case min heap is being considered
// The smallest element will be popped and added in the result list. Once an element is popped, next node of the corresponding list is added in the min heap.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // edge case
        if(lists == null || lists.length == 0) return null;
        
        // min heap declaration
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode result = new ListNode(0); // result
        ListNode curr = result;
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        
        while(!pq.isEmpty()) {
            if(pq.peek() != null) {
                ListNode temp = pq.poll();
                if(temp.next != null)
                    pq.offer(temp.next);
                curr.next = temp;
            }
            curr = curr.next;
        }
        return result.next;
    }
}
*/

// Approach 2: Split and merge

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return splitList(lists, 0, lists.length-1);
    }
    
    public ListNode splitList(ListNode[] lists, int start, int end) {
        if(start < end) {
            int mid = (start+end)/2;
            ListNode l1 = splitList(lists, start, mid);
            ListNode l2 = splitList(lists, mid+1, end);
            return mergeLists(l1, l2);
        }
        return lists[start];
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode ref = curr;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
        return ref.next;
    }
}

