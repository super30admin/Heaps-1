/*
 In this problem, we use a MinHeap to merge k sorted lists. The Heap is constructed to only contain k nodes, and it is made from the
 heads of all the k lists initially. Each time a new element is added onto the heap, the root element is removed and added onto the 
 final merged list.
 
 Did this code run on leetcode: Yes
 */
class Solution {
    //Time Complexity: O(N.log(k)), N = total number of ListNodes, k = number of lists/size of the heap
    //Space Complexity: O(K), K = size of heap
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head: lists)
        {   
            if(head != null)
                pq.add(head);
        }
        //We make a dummy head node so that we can return the head of the merged list 
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            //Once we choose an element from a particular list, we add the next element from that list onto the heap
            if(min.next != null)
                pq.add(min.next);
        }
        
        return result.next;
        
    }
}