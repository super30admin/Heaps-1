//Time Complexity : O(n log k) in case of min heap, n is the no of elements in tha array, k is the largest number that we want. O(n log(n-k)) in case of max heap
//Space Complexity : O(k) in case of min heap, O(n-k) in case of max heap
//Did this code run successfully on leetcode: Yes
//we maintain a min heap of size k and insert the elements into the heap, whenever the size exceeds k value, we pop out the root element which will be the min value of heap. After inserting all the elements, we get the kth largest element at the top of heap
class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //using min heap
        for(int i=0; i<nums.length; i++) {  
            pq.add(nums[i]);
            if(pq.size() == k+1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    /*
    public int findKthLargest(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        //using min heap
        for(int i=0; i<nums.length; i++) { 
            int n = nums.length; 
            pq.add(nums[i]);
            if(pq.size() > n-k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }*/
}