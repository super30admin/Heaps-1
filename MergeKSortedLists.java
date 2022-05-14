
// Solution 1 

class MergeKSortedLists {
		/*
      *
      * Time Complexity: O(nk log(k)) where we go through all elements of the lists and log(k) insertion to priorityQueue
      * Space Complexity: O(k)
      *  
    */
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node: lists) {
            if (node != null) {
                pq.add(node);   
            }            
        }    
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        
        return dummy.next;
    }
}

// Solution 2 can be done using O(nk2) where we can use two pointers, merge
// initial two lists in ascending order. Later the new list can be compared
// with the next list and merged and so on. 
// n will be the length of each individual list
// k with be the no. of list in total
// since we need to perform merge on two lists and later subsequent list, the
// list keeps growing and the final result is based on (k square) * n
