//Time Complexity :O(N*LOG(K)).
//Space Complexity :O(K)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach

class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists,0,lists.length-1);
    }
    private ListNode partition(ListNode[] lists, int start, int end){
        if(start==end){
            return lists[start];
        }
        if(start<end){
            int mid = start +(end-start)/2;
            ListNode L1 = partition(lists,start,mid);
            ListNode L2 = partition(lists,mid+1,end);
            return merge(L1,L2);
        }
    return null;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(null == l1){return l2;}
        if(null == l2){return l1;}
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode current = result;
        while(null != l1 && null != l2){
            if(l1.val < l2.val){
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }else{
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        if(null != l1){
            current.next = l1;
        }
        if(null != l2){
            current.next = l2;
        }
    return result.next;
    }
}