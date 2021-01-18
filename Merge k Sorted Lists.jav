/*
# if n is average length and k is lists size
# time - O(nk^2) as each time the list grows bigger and we travel the same elements again in next iteration
# space - O(nk) 
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if lists is None or len(lists) == 0:
            return None
        
        result = ListNode(float('-inf'))
        
        for l in lists:
            result = self.merge(result, l)
        
        return result.next
    
    def merge(self, l1, l2):
        dummy = ListNode(float('-inf'))
        ans = dummy
        
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                dummy.next = l1
                l1 = l1.next
            else:
                dummy.next = l2
                l2 = l2.next
                
            dummy = dummy.next
            
        if l1 is not None:
            dummy.next = l1
        if l2 is not None:
            dummy.next = l2
            
        return ans.next
*/

/*
// if n is average length and k is lists size
// time - O(nk^2) as each time the list grows bigger and we travel the same elements again in next iteration
// space - O(nk) 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        
        ListNode result = new ListNode(Integer.MIN_VALUE);
        for (ListNode l: lists){
            result = merge(result, l);
        }
        return result.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode ans = dummy;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        
        if (l1 != null)
            dummy.next = l1;
        if (l2 != null)
            dummy.next = l2;
        return ans.next;
    }
}

*/
/*
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if lists is None or len(lists) == 0:
            return None
        
        class Wrapper():                                
            def __init__(self, node):
                self.node = node
            def __lt__(self, other):
                return self.node.val < other.node.val
            
        dummy = ListNode(float('-inf'))
        result = dummy
        
        pq = []
        for l in lists:
            if l is not None:
                heapq.heappush(pq, Wrapper(l))              # we have to specify wrapper as when values will be equal we will run into prob if we use heapq.heappush(pq, (l.val, l))
        
        while len(pq) > 0:
            cur = heapq.heappop(pq).node
            dummy.next = cur
            dummy = dummy.next
            
            if cur.next is not None:
                heapq.heappush(pq, Wrapper(cur.next))
        
        return result.next
*/

// Time Complexity : O(nk logk) where n is average linkedlist size and k is no of linkedlist 
// Space Complexity : O(k)

// Your code here along with comments explaining your approach: Maintained all k heads in heap and every time popped a node
// and checked for next node and pushed onto heap

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for (ListNode l : lists){    
            if (l != null)
                pq.add(l);
        }
            
        
        while(!pq.isEmpty()){
            ListNode cur = pq.remove();
            dummy.next = cur;
            dummy = dummy.next;
            if (cur.next != null)
                pq.add(cur.next);
        }
        return result.next;
    }
    
}
        
        