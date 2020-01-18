// Time Complexity - O(nk)
// Space Complexity - O(nk)
// This solution worked on LeetCode

// Brute Force 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode res = merged;
        for(int i=0;i<lists.length;i++){
            merged = merge(merged,lists[i]);   
        }
        return res.next;
        
    }
    
    ListNode merge(ListNode list1, ListNode list2){
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = result;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                result.next = list1;
                list1 = list1.next;
            }
            else{
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        if(list1 != null) result.next= list1;
        else if(list2 != null)  result.next = list2;
        return dummy.next;
    }
}

// Time Complexity
// Space Complexity
// This solution worked on LeetCode
// Optimal Heap Solution

//
