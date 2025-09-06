
// Time Complexity: O(N log K) where N is the number of elements in the array and K is the size of the heap.
// Space Complexity: O(K) for the heap.

//We use a min-heap of size k to keep track of the k largest elements seen so far.
//When we finish processing all elements, the root of the min-heap will be the kth largest element.
//We add each element to the heap and if the size of the heap exceeds k, we remove the smallest element (the root).


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }
}