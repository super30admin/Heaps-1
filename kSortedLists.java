// TC O(nm * log(m)) SC O(m) m is the number of linkedlists 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = result; 
        for(int i=0; i < lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.remove();
            dummy.next = new ListNode(temp.val);
            dummy = dummy.next;
            if(temp.next != null) pq.add(temp.next);
            
        }
        return result.next;
        
    
    }
}


// Another approach: Merge K Lists using recursively merge two lists
// Suppose n elements on average in each list TC 1n + 2n + 3n + 4n + (k-1)n = n(k ^2) greater than nklogk  and SC O(1)
// Leetcode best : Approach Merge with Divide And Conquer TC O(nk logk) and SC O(1)
/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
        ListNode mergedList = new ListNode(Integer.MIN_VALUE);
        ListNode result = mergedList; 
        for (ListNode head : lists){
            mergedList = mergeList(mergedList, head);
            //System.out.println(dummy.val);
        }
        return result.next;
        
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode curr = new ListNode(-1);
        ListNode result = curr; 
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
                
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
        return result.next;
    
}
}





TCO(n * k logk) SC O(1)
Intuition & Algorithm

This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

Pair up \text{k}k lists and merge each pair.

After the first pairing, \text{k}k lists are merged into k/2k/2 lists with average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.

Repeat this procedure until we get the final sorted linked list.

Thus, we'll traverse almost NN nodes per pairing and merging, and repeat this procedure about \log_{2}{k}log 
2
​
 k times.
 
 
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        int k = 1;
        while (k < lists.length)
        {
            // 0, 1, 2, 3
            // 0, 1, 2
            // 0, 1, 2, 3, 4, 5, 6, 7, 8
            //System.out.println("lists length is: " + lists.length);
            for (int i = 0; (i + k) < lists.length; i+= 2 * k)
            {
                /*System.out.println("i is: " + i);
                System.out.println("i+k is: " + (i+k));
                if (lists[i] == null)
                {
                    System.out.println("lists[i] is: null");
                } else
                    System.out.println("lists[i+k] is: " + lists[i].val);
                if (lists[i+k] == null)
                {
                    System.out.println("lists[i] is: null");
                } else
                    System.out.println("lists[i+k] is: " + lists[i+k].val);
                */
                /*
                lists[i] = mergeTwoSortedList(lists[i], lists[i+k]);
                
            }
            // increase gap for each iteration
            // 1 -> 2 -> 4 -> 8
            k *= 2;
        }

        return lists[0];
    }
    
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2)
    {
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode ans = new ListNode();
        ListNode curr = ans;
        while (p1 != null && p2 != null)
        {
            if (p1.val < p2.val)
            {
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            } else
            {
                curr.next = p2;
                curr = curr.next;
                p2 = p2.next;
            }
        }
        
        curr.next = p1 == null ? p2 : p1;
        
        return ans.next;
    }
}
*/
*/

