//Solution 1- Using min heap
class Solution {

    //Time Complexity : 0(nklogk) where n is average length of 1 list. k is the no. of lists given
    //Space Complexity : 0(k) where k is the no of lists
    //Did it successfully run on leetcode: yes
    //Did you face any prolem while coding: no

    //In short explain your code

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1); //creating a dummy node to traverse through the final sorted list
        ListNode current = dummy;   //creating to extract elements from queue and merging them onto final list
        PriorityQueue<ListNode> p = new PriorityQueue<>((a,b) -> a.val - b.val); //creating custom min head as we are dealing with linked list or nodes
        for(ListNode head : lists){ //Storing the head of all the lists in the array
            if(head != null){
                p.add(head);
            }
        }
        while(!p.isEmpty()){    //till the queue is not empty
            ListNode min = p.poll();    //extracting the minimum element from queue or heap
            current.next = min; //storing it to the final list
            current = current.next; //moving the pointer forward
            if(min.next != null){   //extracting 2nd element from that list out of k lists which gave the minimum to the heap and adding it to priority queue to continue the process.
                p.add(min.next);
            }
        }
        return dummy.next;  //returning dummy's next which contains a linked list of all the nodes in sorted order
    }
}

//Brute Force

//Time Complexity : 0(nk^2) where n is average length of 1 list. k is the no. of lists given
//Space Complexity : 0(nk)
//Did it successfully run on leetcode: yes
//Did you face any prolem while coding: no

//In short explain your codeI have used a general merge sort below to sort and arrange elements from different list to a single list

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(ListNode l : lists){
            result = merge(result, l);
        }
        return result;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;

        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return dummy.next;
    }
}