// Time Complexity: O(n)
// Space Complexity: O(n)

// Approach: Using min heap with priority queue.
// 1. For every number in the array, add it to the min heap
// 2. If the index of the number in the array >= k, extract the min from heap,
//  so that at the end of traversal, we have kth largest number at the head of heap.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(i>=k){
                pq.poll();
            }
        }
       return pq.poll();
    }
}

// Time complexity: O(nlogk) 
// Space Complexity: O(k * length of each list)
// Approach: Keep a priority queue which conatins the k nodes that has to be compared.
// At each iteration, get the min element node out of the k nodes from priority queue and push its next node to queue.
// and construct a new ListNode in the order of the popped nodes.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new MyComparator());
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(!pq.isEmpty()){
            ListNode popped = pq.poll();
            tmp.next = popped;
            tmp=tmp.next;
            if(popped.next!=null){
                pq.add(popped.next);
            }
        }
        return head.next;
    }
}

class MyComparator implements Comparator<ListNode>{
    public int compare(ListNode node1, ListNode node2){
        if(node1.val>node2.val){
            return 1;
        }
        else return -1;
    }
}
