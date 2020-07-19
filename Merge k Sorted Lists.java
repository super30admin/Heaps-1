// Time Complexity : nklog(k), k is number of lists, n is largest list 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//MinHeap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //check for null or empty case
        if(lists == null || lists.length == 0) return null;
        //create a temp list, to get reference to first element on adding listnodes
        ListNode temp = new ListNode(-1);
        //point result to the temp list
        ListNode result = temp;
        //custom comparator, to access value of listnodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        
        //add all the first listnodes into PQ
        for(ListNode first : lists) {
            if(first != null) {
                pq.add(first);
            }
        }
        
        //while PQ is not empty
        while(!pq.isEmpty()) {
            //get the top (minimum) of PQ
            ListNode minimum = pq.poll();
            //add it to temp
            temp.next = minimum;
            //move temp
            temp = temp.next;
            //move pointer to next of element polled (if exists) and add to PQ
            if(minimum.next != null) {
                minimum = minimum.next;
                pq.add(minimum);
            }
        } //when PQ is empty, temp is sorted and points to end
        //and result points to head of temp (-1), so return result.next; 
        return result.next; 
    }
}

