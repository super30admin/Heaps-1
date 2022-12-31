//Time Complexity: O(nklogk) // n is the average size of the list and k is the number of list
//Space Complexity: O(k)

/*
 * maintain a min head and store all the lists in it. while queue is not empty
 * get the min and append it to the result and now if the list is not empty add it back to the queue.
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        int n = lists.length;
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}