//Problem 1
//TC O(nlogk)
//SC O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
//Problem 2
//TC O(nlogk)
//SC O(k)
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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
        {
            return null;
        }
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy= new ListNode(-1);
        ListNode cur=dummy;
        for(ListNode list:lists)
        {
        if(list!=null)
        {
                pq.add(list);
        }
        }
        while(!pq.isEmpty())
        {
            ListNode min=pq.poll();
            cur.next=min;
            cur=cur.next;
            if(min.next!=null)
            {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}