// Time complexity: O(N Log K) N:all the elements K:applied heapify for k elements.
// Space complexity: O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Using MinHeap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>( (a,b) -> (a.val - b.val));
        for(ListNode head : lists){
            if(head!=null){
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
        
    }
}


// Time complexity: O(NK) N:all the elements (nk) 
// Space complexity: O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for (ListNode list : lists){
            if( list!=null){
                merged = merge(list,merged);
            }
        } 
        return merged.next;
    }

    private ListNode merge(ListNode n1, ListNode n2){
        ListNode p1 = n1;
        ListNode p2 = n2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while( p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
            }else{
                curr.next = p2;
                p2 = p2.next;

            }
            curr = curr.next;
        }
        if(p1!=null){
            curr.next = p1;
        }
        if(p2!=null){
            curr.next = p2;

        }
        return dummy.next;
    }
}