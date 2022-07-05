// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
    if(lists==null) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode l : lists){
            while(l!=null){
           pq.add(l.val);
           l=l.next;
       } 
        }
       int cnt=pq.size();
        ListNode res = new ListNode();
        ListNode temp = res;
        
    while(cnt!=0){
        temp.next=new ListNode(pq.poll());
        temp=temp.next;
            cnt--;
    }
        return res.next;
    }
    
}
