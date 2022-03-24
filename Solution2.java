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
    public class Pair implements Comparable<Pair>{
        ListNode val;
        int lidx;
        
        Pair(ListNode val, int lidx){
            this.val = val;
            this.lidx = lidx;
        }
        
        @Override
        public int compareTo(Pair other){
            if(this.val!=null && other.val!=null){
                return this.val.val - other.val.val;
            }else if(this.val==null && other.val!=null){
                return other.val.val;
            }else if(this.val!=null && other.val==null){
                return this.val.val;
            }else{
                return 0;
            }
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
            if(lists.length == 0){
                return null;
            }
            
            ListNode result = null;
            ListNode temp = result;
            boolean flag = false;
            
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int i=0; i<lists.length; i++){
                if(lists[i]==null){
                    continue;
                }
                pq.add(new Pair(lists[i], i));    
            }
        
            while(pq.size() > 0){
                Pair rp = pq.remove();
                
                if(rp.val == null){
                    continue;
                }
                
                if(temp==null){
                    temp = new ListNode(rp.val.val);
                }else{
                    temp.next = new ListNode(rp.val.val);
                    temp = temp.next;
                }
                
                
                if(flag==false){
                    flag=true;
                    result = temp;
                }
            
                
                if(rp.val.next!=null){
                    pq.add(new Pair(rp.val.next, rp.lidx));
                }
                
            }
        
           
            return result;
    }
}
