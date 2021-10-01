// Time Complexity : O(N log k)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
    
        PriorityQueue<Integer> q = new PriorityQueue();
        
        for(int i=0;i<lists.length;i++) {
            add(q,lists[i]);
 
        }
        if(q.size() == 0) 
            return null;
        ListNode temp = new ListNode(q.poll());
        ListNode s = temp;
        
        while(q.size()>0) {
            ListNode m=new ListNode(q.poll());
            s.next = m;
            s = s.next;      
        }
        return temp;  
    }
    
    public void add(PriorityQueue<Integer> b , ListNode a)
    {
        
       if(a == null) return;
        ListNode temp=a;
        while(a != null) {
           b.add(a.val);
            a = a.next;
    
        }
    }
}
