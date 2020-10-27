// TC: O(klogk) + N*O(logK), O(NlogK) to form min heap, worst case add all elements to heap, input in ascending order
// SC: O(k) to form the heap
// Diffucilty: No
// Did it run on leetcode: yes

// Approach:
// used priority queue to implement heap containing only k elements
// inorder to add new element to heap need to know least of the bunch hence min heap
// when size()==k check if new element is > cur min element in heap, poll() and add

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (n1, n2) -> n1-n2);
        
        for(int n : nums){
            if(pq.size()<k){
                pq.offer(n);
            }
            else if(pq.size()==k && n>pq.peek()){
                pq.poll();
                pq.offer(n);
            }
        }
        
        return pq.poll();
    }
}