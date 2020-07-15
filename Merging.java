Executed in leetcode- Yes

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        ListNode result= null;
        int balListNodes=lists.length;
        for(ListNode ln: lists){
            if(ln==null) balListNodes--;
             else pq.add(ln);
        }
        if(balListNodes==0) return null;
        if(balListNodes==1) return pq.poll();
        ListNode curr=null;
        while(pq.size()==balListNodes && balListNodes>1){
            ListNode smallest = pq.poll();
            if(result==null) {
                result=smallest;
                curr=smallest;
            }
            else {
                curr.next=smallest;
                curr= curr.next;
            }
            ListNode nxt=smallest.next;
            if(nxt!=null)
                pq.add(nxt);
            else
                balListNodes--;   
            if(balListNodes==1) curr.next=pq.poll();
        }
        
    return result;
    }
}
