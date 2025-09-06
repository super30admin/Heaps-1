
//Time Complexity: O(N log k) where N is the total number of nodes and k is the number of linked lists
//Space Complexity: O(k) for the heap


//we use a min-heap to keep track of the smallest current node among the k lists.
//We add the head of each list to the heap. 
//We then repeatedly extract the smallest node from the heap and add it to the merged list.
//If the extracted node has a next node, we add that next node to the heap.  

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}
