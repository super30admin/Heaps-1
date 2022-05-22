// TC O(nm * log(m)) SC O(m) m is the number of linkedlists 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = result; 
        for(int i=0; i < lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.remove();
            dummy.next = new ListNode(temp.val);
            dummy = dummy.next;
            if(temp.next != null) pq.add(temp.next);
            
        }
        return result.next;
        
    
    }
}


// Another approach: Merge K Lists using recursively merge two lists
// Suppose n elements on average in each list TC 1n + 2n + 3n + 4n + (k-1)n = n(k ^2) greater than nklogk  and SC O(1)
// Leetcode best : Approach Merge with Divide And Conquer TC O(nk logk) and SC O(1)
/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
        ListNode mergedList = new ListNode(Integer.MIN_VALUE);
        ListNode result = mergedList; 
        for (ListNode head : lists){
            mergedList = mergeList(mergedList, head);
            //System.out.println(dummy.val);
        }
        return result.next;
        
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode curr = new ListNode(-1);
        ListNode result = curr; 
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
                
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
        return result.next;
    
}
}

*/

