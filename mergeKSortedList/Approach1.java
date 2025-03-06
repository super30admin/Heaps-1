package mergeKSortedList;

// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity : O((n*k)logk) n- average size of each list k - no of lists
// Space Complexity : O(k)

//The idea here is to compare the first nodes in each list, find the minimum among them and add to the result.
//We move the pointer to the next element of the node in the list which is added to result.
//We keep doing this till all the nodes in all the lists are added to the result list
//We use priority queue for min-heap to find the minimum among all the nodes

class Approach1 {
    public ListNode mergeKLists(ListNode[] lists) {

        // Nlogk
        //comparator is used to arrange the nodes in the heap in ascending order
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a,ListNode b) -> a.val - b.val);

        for(ListNode head : lists) {
            //  add all first nodes inside PQ
            if(head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode minNode = pq.poll();  //log k
            curr.next = minNode;
            curr = curr.next;

            if(minNode.next != null) {
                pq.add(minNode.next);
            }

        }

        return dummy.next;
    }
}