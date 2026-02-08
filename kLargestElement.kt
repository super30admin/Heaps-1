// In this solution, we use a min heap. we add elements to the heap until its size exceeds k. When the size exceeds k, we remove the smallest element from the heap. 
//This way, we maintain a heap of size k that contains the k largest elements from the array. The top of the heap will be the kth largest element.
// Time complexity: O(n log k) - We iterate through all n elements and each insertion and removal operation on the heap takes O(log k) time.
// Space complexity: O(k) - The heap can contain at most k elements.

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val n = nums.size
        var result = Int.MAX_VALUE

        val pq = PriorityQueue<Int>() 

        for (num in nums) {
            pq.add(num)

            if(pq.size > k) {
                pq.poll()
            }
        }
        return pq.peek()
    }
}