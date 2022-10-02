// Time complexity: O(nklogk) where n is the avg number of nodes in each list, k is the total number of lists and logk is for adding to the heap (and heapify). Heap will have max of k nodes at any given time

// Space comlexity: O(k)

// Approach: We will have pointers at the head of every list. We will add all heads of k lists into the minheap. Then we will poll the min element from the heap (topmost element). We will add that element to the result and then add the next element of that min element into the heap. basically move next in that list.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // we need to explicitly add comparator logic as we are comparing list nodes. We don't have to do this if we are using integers in the minheap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        
        // add the first node (head) of all lists into the minheap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        
        // our final result
        ListNode result = new ListNode(-1);
        // pointer to iterate through our result so that we can add elements and move ahead
        ListNode curr = result;
        while (!minHeap.isEmpty()) {
            // pop minimum from heap
            ListNode min = minHeap.poll();
            // make result point to min
            curr.next = min;
            // move current head
            curr = curr.next;
            // move the pointer of the list ahead where we found the minimum element and add the next element to the heap
            if (min.next != null) {
                minHeap.add(min.next);
            }
        }
        
        return result.next;
    }
}