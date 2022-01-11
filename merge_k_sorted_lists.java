class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; //if there are no lists or the length of the lists is 0, we return null
        ListNode dummy = new ListNode<>(-1); //we are creating a listnode with name as dummy and we are initially giving it a value as -1;
        ListNode curr = dummy; // we create another listnode with name as curr and we pass the value present in the dummy to the listnode
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a-val - b.val); // we are creating a priority queue with name as pq  which acts as the min heap and listnode is the input for it.
        for(ListNode list : lists) { // we go through every lists and store each of it in the list.
            if(list != null) { //if the list is not equal to null
                pq.add(list); // we add each of it to the priority queue. we are adding all the heads of different lists to the priority queue.
            }
        }
        while(!pq.isEmpty()) { //we are checking if the pq is not empty. If it is not empty
            ListNode min = pq.poll(); // we are taking the first element from the pq and storing it in a listnode variable called as min.
            curr.next = min; // one of the head of the lists comes out of the priority queue and we add it to the curr.next
            if(min.next != null) { // if the next element to min is not equal to null
                pq.add(min.next); //we add it to the priority queue.
            }
            curr = curr.next; //we increment the current.
        }
        return dummy.next; // in the end, we return the dummy.next
    }
}
//tc and sc - O(nk log k) and O(k)