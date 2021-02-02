// Using minHeap
// TC : O(NlogK)
// SC : O(K)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int findKthLargest(int[] nums, int k) {
       Queue<Integer> minHeap = new PriorityQueue<Integer>(
           (n1, n2) -> n1 - n2);
       for (int num : nums)
       {
           minHeap.add(num);
           if (minHeap.size() > k)
               minHeap.poll();
       }
      return minHeap.poll();
    }
}

// Using maxHeap
// TC : O(Nlog(N-K))
// SC : O(N-K)
// // Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> maxHeap = new PriorityQueue<Integer>(
//            (n1, n2) -> n2 - n1);
//         int N = nums.length;
//         int min = Integer.MAX_VALUE;
//        for (int num : nums)
//        {
//            maxHeap.add(num);
//            if (maxHeap.size() > N-k)
//            {
//               min = Math.min(min, maxHeap.poll());
//            } 
//        }
//       return min;
//     }
// }

// Using maxHeap
// TC : O(Nlog(N-K+1))
// SC : O(N-K+1)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> maxHeap = new PriorityQueue<Integer>(
//            (n1, n2) -> n2 - n1);
//         int N = nums.length;
        
//        for (int num : nums)
//        {
//            maxHeap.add(num);
//            if (maxHeap.size() > N-k+1)
//            {
//               maxHeap.poll();
//            } 
//        }
//       return maxHeap.poll();
//     }
// }
