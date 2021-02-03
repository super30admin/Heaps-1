//Problem 83 : Mege K Sorted List
//TC:O(nkLog(k)), k stands for number of lists and n stands for number of elements in each list, because we are iterating over nk elements and will store k elements
//SC:O(k), always inserting only k nodes

/*Steps
  
   Bruteforce: //TC: nkLognk - for sorting the list+O(NK) for generating new list=> nkLognk | SC: O(nk)-> for the new List.  Create a new list. Iterate over all the list nodes and insert elements in the new list. Sort that list and then create a new LinkedList which will be the output.

   Optimised: TC:O(nkLog(k)) | SC: O(nk)- Using Priority Queue. As the list nodes are sorted in ascending order so iterate over the input and insert list node heads into the priority queue which is min heap because required result is in ascending order. Maintain heap size of k. Start with dummy node, here dummy node will be initialised with MIN_VALUE because here range of input starts from -10^4.
   Iterate over minheap until it is empty. Attach minimum element with the dummy node and if min element next node is not null put it in heap. In addition, move the dummy pointer. 

   //2nd Optimised solution in terms of space complexity
   Note:  If asked for saving the space complexity. Can be done without using priority queue. Just Create a dummy merged list. Iterate over the given list and write logic to merge two lists and return the merged list. Repeat it until all the input is traversed.
   //TC: k*nk=> nk^2, because finally all nk elements will be merged
   //SC:O(1), because we have to return merged list so it wont be considered as an auxillary space; 
    


*/
import java.util.*;

class Solution83 {
    class ListNode{
       ListNode next;
       int val;
       ListNode(int val){
        this.val = val;
       }
    }
  
    //Using Priority Queue
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);//here MIN_VALUE because here range of input starts from -10^4
        
        if(lists==null || lists.length==0) return dummy.next;
        
        //Bruteforce
        //TC: nkLognk - for sorting the list+O(nk) for generating new list=> nkLognk
        //SC: O(nk)-> for the new List
        
        
        //PriorityQueue
        //TC:O(nkLog(k)), k stands for number of lists and n stands for number of elements in each list, because we are iterating over nk elements and will store k elements
        //SC:O(k), always inserting only k nodes
        //As we need list in ascending order thats why min  heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        //here min heap will be of k size which is number of lists
        for(ListNode head : lists){
            if(head!=null) minHeap.add(head);//because head can be empty
        }
        
        ListNode curr = dummy;
        
        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            
            curr.next = min;
            curr  = curr.next;
            
            if(min.next!=null) minHeap.add(min.next);
            
        }
           
        return dummy.next;
    }




    //Without Priority Queue-- Simply Merging two linkedlist
    //TC: k*nk=> nk^2, because finally all nk elements will be merged
    //SC:O(1), because we have to return merged list so it wont be considered as an auxillary space;
    
    /*public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        
        if(lists==null) return merged.next;
        
        for(ListNode head:lists){
            merged = mergeLists(head,merged);
        }
        
        return merged.next;
    }
    
    private ListNode mergeLists(ListNode head,ListNode merged){
        
        ListNode dummy = new ListNode(-1);
        
        ListNode m1 = head;
        ListNode m2 = merged;
        
        ListNode curr = dummy;
        
        while(m1!=null && m2!=null){
            
            if(m1.val<m2.val){
                curr.next = m1;
                m1 = m1.next;
            }else{
                curr.next = m2;
                m2 = m2.next;
            }
            curr = curr.next;
        }
        
        if(m1!=null){
            curr.next = m1;
        }
        
        if(m2!=null){
            curr.next = m2;
        }
        
        return dummy.next;
    }*/
    
    
    
}
