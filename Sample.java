import java.util.*;

class Sample {

    /**
     * Time complexity : O(N logK)
     * Space complexity : O(K) K is size of the heap
     * 
     * Approach
     * 1. Maintain a min heap and add elements greater than top element of the heap.
     * 2. At the end, heap will have kth max element at the top
     */
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int n : nums) {
            if(pq.size() < k){
                pq.add(n);
            }
            else {
                if(n > pq.peek()) {
                    pq.poll();
                    pq.add(n);
                }
            }
        }
        
        return pq.peek();
        
    }

    /**
     * Time complexity : O(NK logK)
     * Space complexity : O(K) K is size of the lists
     * 
     * Approach
     * 1. We can maintain a min heap and add element from head of every list.
     * 2. from the top element from heap, we can poll the minimum element and add the next element of that
     * min element.
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0)
            return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }   
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            tail.next = min;
            tail = tail.next;

            if(min.next != null) {
                pq.add(min.next);
            }
        }
      
        
        return dummy.next;
        
    }
}