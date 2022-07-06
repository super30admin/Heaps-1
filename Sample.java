//****Kth LARGEST ELEMENT IN ARRAY USING MIN HEAP****
//KEEP SIZE OF HEAP AS K;
//Time complexity:nlogk where n is the size of array and k is the size of heap
//Space complexity:0(k);
//Leetcode runnable: Y;
//Any doubts: No;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        //Iterate through array and add elements to heap
        for(int num:nums)
        {
            pq.add(num);
            
            //If size exceeds perform pop;
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

//****Kth LARGEST ELEMENT IN ARRAY USING MAX HEAP****
//KEEP SIZE OF HEAP AS N-K;
//Time complexity:nlog(n-k) where n is the size of array and k is the size of heap
//Space complexity:0(n-k);
//Leetcode runnable: Y;
//Any doubts: No;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=nums.length;
        int result=Integer.MAX_VALUE;
        //Iterate through array and add elements to heap
        for(int num:nums)
        {
            pq.add(num);
            
            if(pq.size()>n-k)
            {
                result=Math.min(result,pq.poll());
            }
        }
        return result;
    }
}

//****Kth LARGEST ELEMENT IN ARRAY USING MAX HEAP****
//KEEP SIZE OF HEAP N-K+1
//Time complexity:nlog(n-k) where n is the size of array and k is the size of heap
//Space complexity:0(n-k);
//Leetcode runnable: Y;
//Any doubts: No;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=nums.length;
        //Iterate through array and add elements to heap
        for(int num:nums)
        {
            pq.add(num);
            
            if(pq.size()>n-k+1)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

//****MERGE K-SORTED LISTS****
//Time complexity:nlogk where n is the total nodes and logk is of insertion of k nodes at particular time in the heap.
//Space complexity:0(k)
//Leetcode runnable:Y
//Any doubts:N

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
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode result=new ListNode(-1);
        ListNode curr=result;
        
        //Adding the heads to the queue.
        for(ListNode head: lists)
        {
            if(head!=null)
            {
                pq.add(head);
            }
        }
       
        //Popping the top node from heap
        //As that would be the minimum
        //Parallely adding it to the result
        //Whichever node is popped looking for its next if it has next, add to pq.
        while(!pq.isEmpty())
        {
            ListNode min=pq.poll();
            curr.next=min;
            curr=curr.next;
            if(min.next!=null)
            {
                pq.add(min.next);
            }
        }
        
        return result.next;
    }
}
