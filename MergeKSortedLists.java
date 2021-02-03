// Time Complexity : 0(n log k) n is the total no of elements and k is the number of sub lists
// Space Complexity : 0(k) k is the number of sub lists as there will max k elements inside pq at any given time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        //min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)-> a.val-b.val);
        //dummy node and result node
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;

        //put first element of all the sub lists in min heap
        for(ListNode tmp : lists){
            if(tmp!=null)
                pq.add(tmp);
        }

        //iterate through the priority queue
        while(!pq.isEmpty()){
            //pop min element out and add it behind dummy node
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            //add next element from that sub list into the heap
            if(min.next != null){
                pq.add(min.next);
            }
        }

        return result.next;
    }
}