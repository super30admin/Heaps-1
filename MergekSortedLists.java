// Time Complexity : O(n log n) 
// Space Complexity : O(n) elements in priority queue. 

// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We use a priority queue and add all elements in PQ first, then we loop until pq is empty. We keep adding elements in each iterations. 
// we also use a dummy node to keap a pointer to the head.
//Runtime: 9 ms, faster than 26.81% of Java online submissions for Merge k Sorted Lists.
//Memory Usage: 45.3 MB, less than 5.04% of Java online submissions for Merge k Sorted Lists.

class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<Integer> pq= new PriorityQueue<>();
       for (ListNode l:lists){
           while (l!=null){
               pq.add(l.val);
             l=l.next;       
           }
       }
        
       ListNode dummy= new ListNode(-1); 
        ListNode head=dummy;
       while (!pq.isEmpty()){
           head.next= new ListNode(pq.remove());
           head=head.next;
       } 
       return dummy.next;
    }
    
    
}

//another solution
// time is O(n log k)
//space O(k)
// intead of adding all elements to the priority queue, we added only k elements. then we remove one and add the next one of recently remove to queue. 
//we keep forming list from recently removed element from queue. 
//Runtime: 4 ms, faster than 81.60% of Java online submissions for Merge k Sorted Lists.
//Memory Usage: 41.5 MB, less than 35.10% of Java online submissions for Merge k Sorted Lists.
  public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
       PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)-> a.val-b.val);
        
       for (ListNode l:lists){
           if (l!=null)
              pq.offer(l);
       }
        
       ListNode dummy= new ListNode(-1); 
        ListNode head=dummy;
       while (!pq.isEmpty()){
           head.next=pq.poll();
           head=head.next;
           if (head.next!=null)
               pq.offer(head.next);
       } 
       return dummy.next;
    }
    

