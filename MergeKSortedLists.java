class Solution {
    
    /* Approach - priority Queue
    * 1. Initialize head to a dummy node. Initialize a priority queue that works like a min heap.
    * 2. Store the first elements of all the lists in a priority queue.
    * 3. Remove the top element of the queue i.e., min of all the current nodes and  add it to the next node of head.
    * 4. If the next of this removed node is not null, add it to the queue. 
    * 5. Repeat the process from step 3 until all nodes are processed.
    * Time Complexity - O(NlogK) where, N is total number of nodes in all the lists and K is number of lists.
    * Space Complexity - O(K) where K is number of lists for priority queue.
    */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prev, head;
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        //dummy node for prev[0]
        head = new ListNode();
        prev = head;
        
        PriorityQueue<ListNode> que = new PriorityQueue<ListNode>((a,b) -> {
           return a.val - b.val; 
        });
        
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                que.add(lists[i]);
            }
        }

        while(!que.isEmpty()){
            ListNode minElem = que.poll();
            //add next elem in the queue
            if(minElem.next != null){
                que.add(minElem.next);
            }
           
            //place min elem in the first list
            prev.next = minElem;
            minElem.next = null;
            prev = prev.next;
        }
        
        return head.next;
        
    }
}