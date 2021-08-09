
//leverage priority queue

class Solution {
    //time- O(Nlogk)
    //space-O(k) : adding all k lists
    public ListNode mergeKLists(ListNode[] lists) {
      
       ListNode res= new ListNode(0);
        ListNode result=res;
       
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        
        for(ListNode node: lists){
            
            while(node!=null){
                
              pq.add(node.val);
                node=node.next;
                
            }
        }
            
            while(!pq.isEmpty()){
                
             result.next= new ListNode(pq.remove());
                result=result.next;
                
            }
        return res.next;
        }
        
        
        
    }