Merge k Sorted Lists

//Time complexity : O(Nlogk) where k is the number of linked lists
//Space complexity : O(N)


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        ListNode dummy = new ListNode(-1);
        ListNode head=dummy;
        for(ListNode list:lists) {
            while(list!=null) {
                minHeap.add(list);
                list=list.next;
            }
        }
        while(!minHeap.isEmpty()) {
            dummy.next=minHeap.poll();
            dummy=dummy.next;
            dummy.next=null;
        }
        return head.next;
    }
}


Kth Largest Element in an Array

//Time complexity: O(Nlogk)
//Space complexity : O(K)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for (int n : nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
