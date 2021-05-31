# Heaps-1

## Problem1
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)
//Min_heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num: nums)
        {
            pq.add(num);//add the element in the PriorityQueue
            while(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.peek();
    }
}


//Max_Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length;
        int result=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for(int num: nums)
        {
            pq.add(num);//add the element in the PriorityQueue
            while(pq.size()>(n-k))
            {
                result=Math.min(result,pq.poll());
            }
        }
        return result;
    }
}

// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : YES 
// Any problem you faced while coding this : NO 






## Problem2 (https://leetcode.com/problems/isomorphic-strings/)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==0 || t.length()==0)
            return false;
        HashMap<Character,Character> sMap=new HashMap<>();
        HashMap<Character,Character> tMap=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char sArr=s.charAt(i);
            char tArr=t.charAt(i);
            if(!sMap.containsKey(sArr))
                sMap.put(sArr,tArr);
            else {
                if(sMap.get(sArr)!=tArr)
                    return false;
            }
            if(!tMap.containsKey(tArr))
                tMap.put(tArr,sArr);
            else 
                if(tMap.get(tArr)!=sArr)
                    return false;
        }
        return true;
    }
}

// Time Complexity :O(NlogK)
// Space Complexity :O(K)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :No






## Problem2
Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
//First Approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode head : lists)
        {
            if(head!=null){
                pq.add(head);//add heads to the priorityqueue   
            }
        }
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
        return dummy.next;
    }
}





//Second Approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        ListNode merge=new ListNode(Integer.MIN_VALUE);
        for(ListNode head: lists)
        {
            merge=mergeLinkedlists(merge,head);
        }
        return merge.next;
        
    }
    private ListNode mergeLinkedlists(ListNode head1,ListNode head2)
    {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                curr.next=head1;
                head1=head1.next;
            }
            else {
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        if(head1==null){
            curr.next=head2;
        }
        if(head2==null){
            curr.next=head1;
        }
        return dummy.next;
    }
    
}

// Time Complexity :O(NlogK)
// Space Complexity :O(K)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :NO


// Time Complexity :O(NK^2)
// Space Complexity :O(K)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :NO



