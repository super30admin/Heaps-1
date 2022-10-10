
// Min heap
public class kthLargInArr_1 {
        public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:nums){
            heap.add(num);
            if(heap.size()>k) heap.poll();
        }
        return heap.poll();
    }
}

// Time Complexity - O(nlogk)
// Space Complexity - O(k)

// Max heap
public class kthLargInArr_2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            heap.add(num);
            if(heap.size() > n-k) min = Math.min(min,heap.poll());
        }
        return min;
    }
}

// Time Complexity - O(nlog(n-k))
// Space Complexity - O(n-k)