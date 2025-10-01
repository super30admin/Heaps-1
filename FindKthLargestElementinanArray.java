/*
- Heap: Priority Queue is used when the operation is performed on limited data k out of n. 
- Heap is a complete or almost complete binary tree
- Min heap:
    parent is smaller than both the babies
- Max heap:
    parent is greater than both the babies
- Whenever a new element is added to the heap, heapify is called.
- Insertion: O(logn) -> element is added and heapify is called if necessary
- Removal: O(logn) -> element is swapped with the last element for easy removal and then heapify is called
- Getting min or max element: O(1)
- Heap Sort: is unstable, meaning the relative order gets messed up hence not super useful in production as compared to quick and merge sort

Approach1: Using Min Heap
- Insert elements in the heap, if the size is greater than k, pop the top element(min element)
- After all the elements are iterated, the heap will have the k largest element in the heap and the top one will be k largest
TC: O(nlogk) -> iterate n element * sort k element so logk
SC: O(k) -> at most k elements in the heap at any time
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/*
Approach2: Using Max Heap
- Insert elements in the heap, if the size is greater than n - k, pop the top element(max element)
- if its smaller than already encountered element, update the temp variable
TC: O(nlog(n-k)) -> iterate n element * sort n-k element 
SC: O(n-k) -> at most k elements in the heap at any time
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
            if(pq.size() > n-k){
                res = Math.min(res, pq.poll());
            }
        }
        return res;
    }
}