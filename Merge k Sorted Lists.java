// Time Complexity : N log k  -> where Nis number of nodes and K is the size of elements in minheap (heads of all lists)
// Space Complexity : o(N) for creating a linkedlist of N nodes 
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists ==null || lists.length ==0)return null;
        Comparator<ListNode> customcomp=new Comparator<>(){
           public int compare(ListNode a,ListNode b){
               // a<b :<0
               // 3   5   a-b
               return a.val-b.val;
           }
        };
        ListNode result=new ListNode(0);
        ListNode cursor=result;
        
        PriorityQueue<ListNode> minheap=new PriorityQueue(customcomp);
        
        for(ListNode headNode:lists)
        {
          if(headNode!=null)  minheap.add(headNode);
        }
        
        while(!minheap.isEmpty()){
            ListNode minNode=minheap.poll();
            cursor.next=minNode;
            cursor=minNode;
            if(minNode.next != null) minheap.add(minNode.next);
        }
        return result.next;
    }
}