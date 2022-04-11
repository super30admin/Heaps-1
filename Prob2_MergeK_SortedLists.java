//Merge Sort on 2 lists out of K lists

// Time Complexity : O(N * K^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode curr : lists){
            if(curr != null)    result = combinedTwoLists(result, curr); // Merging 2 lists one by one from K sorted lists
        }
        
        return result.next;
    }
    
    public ListNode combinedTwoLists(ListNode node1, ListNode node2){
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode curr = result;
        
        while(node1 != null && node2 != null){ //Merging 2 lists
            if(node1.val <= node2.val){
                curr.next = node1;
                node1 = node1.next;
            }else{
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;   
        }
        
        if(node1 != null)  curr.next = node1;
        
        if(node2 != null)  curr.next = node2;
        
        return result.next; // Resultant sorted list of 2 lists
    }
}









/*

//Using Min-Heap
// Space Complexity : O(N * K)
// Time Complexity : O( N*K*Log(K) )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val ); //Min-Heap on Value of ListNode
        
        for(ListNode head : lists){ // Adding head nodes of all k lists in the MinHeap
            if(head != null)       queue.add(head);
        }
        
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode curr = result;
        while(!queue.isEmpty()){ // Fetching node from queue, adding into resultant sorted lists and adding next node of that cuurent node onto Heap
            ListNode temp = queue.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null)    queue.add(temp.next);
        }
        
        return result.next;
        
    }
}

*/