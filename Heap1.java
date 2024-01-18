//1 kth Largest element
//Time Complexity - > O(nlogk)
//Space Complexity -  > O(k)
//Using Min Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Using Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for(int i = 0;i <nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        return pq.peek();
    }
}

//using max heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Using Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a)); 
        int result = Integer.MAX_VALUE;
        int size = nums.length;
        for(int i = 0;i <nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>(size-k)){
                 result = Math.min(result,pq.poll());            }
            
            
        }
        return result;
    }
}

//2nd Merge k Sorted List
//time complexity - >O(nllogk)
//space complexity - > O(k)
//Using Min Heap
class Solution {
    //Using MinHeap
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = new ListNode(-1);
        ListNode curr = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

       for(ListNode listHeads : lists){
           if(listHeads!=null){
               pq.add(listHeads);
           }
           
       }

       while(!pq.isEmpty()){
          ListNode currMin = pq.poll();
          curr.next = currMin;
          curr = curr.next;
          if(currMin.next!=null){
               pq.add(currMin.next);
          }
          
       }       

        return result.next;
        
    }

    
}

//Using Merging
//Time Complexity - > //Time Complexity -> Nlogk - > nklogk
//Space Complexity - > O(1)
class Solution {
    //Using Merging
    //Time Complexity -> Nlogk - > nklogk
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode list : lists){
            merged = merge(merged,list);
        }
        return merged.next;
    }

    private ListNode merge(ListNode l1,ListNode l2){
       ListNode result = new ListNode(-1);
       ListNode curr = result;
       while(l1!=null && l2!=null){
          if(l1.val < l2.val){
           curr.next = l1;
           l1 = l1.next;
       }
       else{
           curr.next = l2;
           l2 = l2.next;
        }
        curr = curr.next;
       }
       if(l1!=null){
           curr.next = l1;
       }
       if(l2!=null){
           curr.next = l2;
       }
       return result.next;

    }
}