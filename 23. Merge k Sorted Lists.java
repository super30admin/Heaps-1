class Solution {
    // Time complexity: O(Nlogk);
    // Space complexity: O(N)
    public ListNode mergeKLists(ListNode[] lists) {
        
        // create dummy node
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        int k = lists.length;
        // use priority queue to imeplement the heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k + 1, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        //add the first node of each list in the heap
        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);   
            }
        }
        
        while(!minHeap.isEmpty()){
            ListNode curr_node = minHeap.poll();
            if(curr_node.next != null){
                minHeap.add(curr_node.next);
            }
            
            cur.next = curr_node;
            cur = cur.next;
        }
        
        return dummy.next;
    }
}