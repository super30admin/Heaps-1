// Time Complexity : O(n logk) + O(n logk) for insertion and deletion of elements from heap (since we are doing n times and the heap size is k)
// where n is the number of total elements in all of the lists and k is the number of lists
// Space Complexity : O(k) where k is the number of lists (the heap size is k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/**
 * Here we add the head of all lists to the minheap where our heap is fixed for
 * size k
 * 
 * by default priorityQueue is minheap of integers but we have to create minheap
 * for listnode
 * 
 * we need a dummy head since we have to create a new linked list
 * 
 * while the minheap is not empty 1) we first pop out the min from pq .. store
 * this as the next of temp(of linked list) 2) add the next of popped out
 * element to the minheap (if it is present) else skip 3) return the head of ll
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new pqComparator());

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (ListNode lsHead : lists) {
            if (lsHead != null)
                pq.add(lsHead);
        }

        while (!pq.isEmpty()) {

            temp.next = pq.poll();
            temp = temp.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return dummy.next;

    }
}

class pqComparator implements Comparator<ListNode> {
    public int compare(ListNode s1, ListNode s2) {
        if (s1.val > s2.val)
            return 1;
        else if (s1.val < s2.val)
            return -1;
        return 0;
    }
}