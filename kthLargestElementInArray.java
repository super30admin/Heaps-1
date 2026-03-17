// Time Complexity : O(nlogK)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Brute force way of achieving this is to sort the array in descending order and return the kth element.But,its
going to be O(nlogn) TC.So, to optimize, we use min heap. Have a priority queue and iterate through the input array
to add numbers to the heap and when the size of heap exceeds k, we pop the element.The idea is with each addition,
heapify automatically happens and smallest element remains at the top(which is not from the set of greatest elements)
As we pop the numbers, ultimately, we will have the kth largest in the top of the heap as we keep only k numbers
in heap at once.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i : nums) {
            heap.offer(i);
            if(heap.size() > k)
                heap.remove();
        }
        return heap.peek();
    }
}