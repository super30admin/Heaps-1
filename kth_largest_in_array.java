//Using min heap
//TC : O(n logk) where n is length of nums array 
//SC : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) { // traversing through all the elements of nums[]
            pq.add(num);
            if (pq.size() > k) { // if size of heap becomes greater than k , then we will pop the element because
                                 // in min heap minimum element is at the top ; so it will be sure that top most
                                 // ele will not be kth largest
                pq.poll();
            }
        }
        return pq.poll(); // suppose k=3 ; so heap contains 3 ele now and the top ele is the 3rd largest
    }
}

// using max heap
// TC : O(n log(n-k)) where n is length of nums array
// SC : O(n-k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > nums.length - k) { // keeping at max n-k elements in the heap
                min = Math.min(min, pq.poll()); // max heap contains max element at the top ; so popping out the max
                                                // element if heap size is > n-k and comparing it with the min
            }
        }
        return min;
    }
}