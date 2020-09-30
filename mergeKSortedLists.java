//Time Complexity: O(nlogk) since the size of heap is always k
//Space Complexity: O(k) at any point the size of heap is k
//Did it run on leetcode: yes
/** Aprroach: I used a min heap which stores listnodes
    first I added all the first node reference of all k lists into minheap
    since it is a minheap the min will be at top at any point of time
    which ever is top I remove it and add its next element into the heap**/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new minHeapListComparator());
        
        for(ListNode node:lists){
            if(node!=null)
                minHeap.add(node);
        }
        
        while(!minHeap.isEmpty()){
            ListNode top = minHeap.remove();
            if(top.next!=null){
                minHeap.add(top.next);
            }
            
            head.next = top;
            head = head.next;
        }
        
        return dummy.next;
    }
    
    class minHeapListComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode l1, ListNode l2) {
            return  l1.val > l2.val ? 1 : -1;
        }
    }
}
