# Heaps-1

## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
## Time Complexity:O(nlogk) Space Complexity:O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}


## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 ## Time Complexity:O(NlogK) Space Complexity:O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> queue=new PriorityQueue<>((a,b) -> a.val-b.val);
       for(ListNode list:lists)
       {
        if(list!=null)
        queue.add(list);
       }
       ListNode dummy=new ListNode(-1);
       ListNode current=dummy;
       while(!queue.isEmpty())
       {
        ListNode smallest=queue.poll();
        current.next=smallest;
        current=current.next;
        if(smallest.next!=null)
        {
            queue.add(smallest.next);
        }
       }

       return dummy.next; 
    }
}
