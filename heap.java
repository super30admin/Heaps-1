Q1: Kth Largest Element 
// Time : NlogN
// Space : 0(k)

// lOGIC: Add elements in PriorityQueue until size is greater than K.Poll the last elemnt
public int findKthLargest(int[] nums, int k) {
    //if empty add elements to priority queue
    PriorityQueue <Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
    for(int i : nums){
            pq.add(i);
        
        if(pq.size() > k){
            pq.poll();
        }
    }
     return pq.poll(); 
    }
}


// Q2: Merge K linked List
// lOGIC: Add all the lists in PriorityQueue.
//If heap is not empty keep polling the minheap one element at a time and also iterate to next element 
// //Take a result LL and add
// Time : NlogN
// Space : 0(k)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<ListNode> heap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        
        ListNode result = new ListNode(0);
        ListNode head = result;
        for(ListNode list : lists){
            if(list!=null){
                heap.offer(list);
            }
        }
        while(!heap.isEmpty()){
            head.next = heap.poll();
            head=head.next;
            if(head.next!=null) heap.offer(head.next);
        }
       return result.next; 
    }
}