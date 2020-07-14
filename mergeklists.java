//Time complexity:O(Nlogk) N->total nodes i.e nk
//Space complexity:O(k)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
	    ListNode dummy=new ListNode(-1);
	    ListNode temp=dummy;
	    for(ListNode i:lists){
            if(i!=null){
		        pq.add(i);
            }
        }
        while(!pq.isEmpty()){
	        ListNode min=pq.poll();
	        temp.next=min;
	        temp=temp.next;
	        if(min.next!=null){
	            pq.add(min.next);
            }   
        }
        return dummy.next;
    }
}