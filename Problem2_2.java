//Time Complexity : O(n * (k^2))
//Space Complexity : O(1)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public ListNode mergeKLists(ListNode[] lists){
        
        if(lists == null || lists.length == 0)
            return null;
        
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode list : lists)
            merged = merge(merged, list);
        
        return merged.next;
    }
    
    private ListNode merge(ListNode m, ListNode n){
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(m!= null && n!= null){
            
            if(m.val < n.val){
                
                curr.next = m;
                m = m.next;
            }
            
            else{
                curr.next = n;
                n = n.next;
            }
            
            curr = curr.next;
        }
        
        if(m!= null)
            curr.next = m;
        
        if(n!= null)
            curr.next = n;

        return dummy.next;
    }
}
