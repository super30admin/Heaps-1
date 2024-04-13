// Heaps-1

// Problem1 
// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

//Min Heap
// Time Complexity : O(nlogk)
// Space Complexity : 0(k)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int num:nums)
        {
            q.add(num);
            if(q.size()>k)
                q.poll();
        }
        return q.peek();

    }
}

//Max Heap
// Time Complexity : O(nlog(n-k)
// Space Complexity : 0(n-k)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b) -> b-a);
        int res=Integer.MAX_VALUE;
        for(int num:nums)
        {
            q.add(num);
            if(q.size()> (nums.length-k))
                res=Math.min(res,q.poll());
        }
        return res;
    }
}


// Problem2

// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

// Time Complexity : O(Nlogk) where N=n*k
// Space Complexity : 0(k)
// Did this code successfully run on Leetcode : yes


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head:lists)
        {
            if(head!=null)
                q.add(head);
        }  
        ListNode res=new ListNode(-1);
        ListNode curr=res;
        while(!q.isEmpty())
        {
            ListNode minNode=q.poll();
            curr.next = minNode;
            curr = minNode;
            if(minNode.next!=null)
            {
                q.add(minNode.next);
            }
        }  
        return res.next;    
    }
}


