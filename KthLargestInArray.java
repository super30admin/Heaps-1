/*
    Time Complexity - O(N log k), where N is the number of elements in nums array.
    Space Complexity - O(k)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {   
        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: nums){
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }
        
        if(!heap.isEmpty())
            return heap.poll();
        return -1;
    }
}
