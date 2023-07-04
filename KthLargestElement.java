// Time Complexity - O(nlogk) -- k is the size of heap and n is the total number of input -- log k is the time for insertion of each element into the heap and hence for n such elements we have nlogk
// Space Complexity - O(k) -- as we maintain a heap of size k
// Approach - we add k elements into the heap and for every k+1 th element we poll out the min element out and hence at the end of the jing bang we just use O(1) to get the last element from the heap which is our answer i.e. kth largest element
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}