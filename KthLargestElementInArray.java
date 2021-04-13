// TC - O(nlogk)
// SC - O(n)

// LC - 215

class Solution {
    public int findKthLargest(int[] nums, int k) {
		// Initialize PriorityQueue or minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Add elements into minHeap
        for(int num : nums){
            minHeap.add(num);
			// If minHeap size is greater than k, remove element
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//         for(int num : nums){
//             maxHeap.add(num);
//         }
//         int removedEle = -1;
//         while(k > 0){
//             removedEle = maxHeap.remove();
//             k--;
//         }
//         return removedEle;
//     }
// }