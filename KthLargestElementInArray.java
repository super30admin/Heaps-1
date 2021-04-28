//MinHeap - PriorityQueue
//      the elements are maintained in the minheap in ascending order and whenever the queue size exceeds k , poll the top element
//Time Complexity - O(N log k)
//                - where N - length of nums
//Space Complexity - O(k)

// class Solution {
//     public int findKthLargest(int[] nums, int k) {

//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//         for(int num: nums){
//             minHeap.add(num);

//             if(minHeap.size() > k){
//                 minHeap.poll();
//             }
//         }


//         return minHeap.poll();
//     }
// }


//MaxHeap - PriorityQueue
//     the elements are maintained in the maxheap in descending order
//      when the heap size exceeds (n-k) replace the min value, finally return min value
//Time Complexity - O(N log (N-k))
//                - where N - length of nums
//Space Complexity - O(k)
class Solution {
  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
    int min = Integer.MAX_VALUE;
    int n = nums.length;

    for(int num: nums){
      maxHeap.add(num);

      if(maxHeap.size() > (n-k)){
        min = Math.min(min, maxHeap.poll());
      }
    }

    return min;
  }
}
