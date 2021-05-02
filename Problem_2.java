//Time Complexity: O(nk) n is the number of linked lists and k is the avg length
//Space Complexity: O(nk) n is the number of linked lists and k is the avg length
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0 ) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        for(ListNode l : lists){
            dummy=merge(dummy, l);
        }
        return dummy.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode res=dummy;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                dummy.next=l2;
                l2=l2.next;
            }
            else{
                dummy.next=l1;
                l1=l1.next;
            }
            dummy=dummy.next;
        }
        if(l1!=null){
            dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }
        return res.next;
    }
}
//Heap Approach
//Time Complexity: O((n+k)log(n+k)) n is the number of linked lists and k is the avg length
//Space Complexity: O((n+k)log(n+k)) n is the number of linked lists and k is the avg length
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if(lists==null || lists.length==0 ) return null;
      PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);
      ListNode dummy = new ListNode(Integer.MIN_VALUE);
      ListNode res=dummy;
      for(ListNode l : lists){
          if(l!=null){
              pq.add(l);
          }
      }
      while(!pq.isEmpty()){
          ListNode min =pq.poll();
          dummy.next=min;
          if(min.next!=null){
              pq.add(min.next);
          }
          dummy=dummy.next;
      }
      return res.next;
  }
}