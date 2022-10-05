Time complexity : O(Nlog k)
Space complexity : O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      
      if(lists==null)
        return null;
      
      ListNode head=new ListNode();
      ListNode node=head;
      Queue<ListNode> queue=new PriorityQueue<>((a,b)->a.val-b.val);
      
      for(ListNode current:lists){
        while(current!=null){
          queue.add(current);
          current=current.next;
        }
      }
      
      node.next=queue.poll();
      node=node.next;
      while(!queue.isEmpty()){
        node.next=queue.poll();
        node=node.next;
      }
      if(node!=null)
        node.next=null;
      return head.next;
    }
}