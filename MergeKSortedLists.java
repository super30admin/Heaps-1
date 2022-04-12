import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Time Complexity : O(n.k.logk); where k is number of lists and n is avg number of elements in a list
//Space Complexity : O(k)
public class MergeKSortedLists {	
	/**Definition for singly-linked list.**/
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int x) { this.val = x;}
		ListNode(int x, ListNode next) { this.val = x; this.next = next;}
	}
	
	/**Approach: Using Min Heap**/
	public ListNode mergeKLists(ListNode[] lists) {        
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list: lists){
            if(list!=null){
                pq.add(list);
            }
        }        
        ListNode result= new ListNode(-1);
        ListNode curr=result;        
        while(!pq.isEmpty()){
            ListNode min=pq.poll();            
            curr.next=min;
            curr=curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }                
        return result.next;
    }

	// Driver code to test above
	public static void main (String[] args) {
		MergeKSortedLists ob = new MergeKSortedLists();
		ListNode[] lists= {new ListNode(1,new ListNode(4,new ListNode(5))), 
						   new ListNode(1,new ListNode(3,new ListNode(4))),
						   new ListNode(2,new ListNode(6))};
		
		ListNode merged=ob.mergeKLists(lists);				
		System.out.print("Merged list:");	
		while(merged!=null) {
			System.out.print("\t"+merged.val);
			merged=merged.next;
		}
	}	
}
