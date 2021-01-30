// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force solution.
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
        if(lists.length==0) return null;
        ListNode head=null;
        ListNode temp=null;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<lists.length;i++){
            //System.out.println(lists[i].val);
             temp=lists[i];
            while(temp!=null){
                arr.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(arr);
        System.out.println(arr);
        if(arr.size()==0) return null;
        head=new ListNode(arr.get(0));
        temp=head;
        for(int i=1;i<arr.size();i++){
            ListNode newNode=new ListNode(arr.get(i));
            temp.next=newNode;
            temp=temp.next;
            
        }
        return head;
    }
}