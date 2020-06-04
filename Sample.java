Problem-1: Kth-Largest Element

/**
Using priority queue(min heap) to keep largest k elements in the queue. In the end return whatever is on top of the queue
TC= n * log(K), log k for the heapify function in the queue
sc = k where k is the max size of the priority queue 
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return -1;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(); // by default the priority queue is based on min heap by default
        
        for(int i: nums){
            if(q.size() < k){
                q.add(i);
            }else{ // once the size becomes equal to k
                if(i > q.peek()){ // if nums[i] > the lowest element on top of the queue. remove it and add nums[i]
                    q.poll();
                    q.add(i);
                }
            }
            
            
        }
        return q.peek();
        
    }
}

Problem-2: Merge-k sorted lists
/**
Brute force solution to merge and sort lists one by one. For eg: merge [(), (3,2)] = (3,2), merge [(3,2),(1,2)] = (1,2,3,4).
TC = n(k)^2 where k is the number of lists and n is the size of each list
sc = O(1)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        
        for(ListNode curList: lists){
            dummy = merge(dummy, curList);
        }
        
        return result.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        
        ListNode cur = new ListNode(-1);
        ListNode result = cur;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }
        if(l2 == null){
            cur.next = l1;
        }
        return result.next;
    }
}

/**
Heap solution for merging both the lists. maintaining the current ListNode type pointers in the priority Queue(min heap). Add the top node(minimum) in the priority queue to the resultant ListNode. Move the pointer to the next element of the current listNode at top of the queue. Continue until the q is empty
TC = nk*log(k) where n is the num of elements in one list * k number of lists. log k to maintain top k nodes in the priority queue
SC= k size of the priority queue maintaining k heads of the given lists
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a,b)-> a.val - b.val);
        ListNode cur = new ListNode(-1); // dummy node
        ListNode result = cur; // resultant list
        
        // fill all the heads of the k lists
        for(ListNode head: lists){
            if(head != null) pq.add(head);
        }
        
        // itearate and add the min node to the resultant list
        while(!pq.isEmpty()){
            ListNode curMin = pq.poll();
            
            cur.next = curMin;
            cur = cur.next;
            
            if(curMin.next != null){ // checking if the curList node has reached the end or not
                pq.add(curMin.next);
            }
        }
        
        return result.next;
    }
}
