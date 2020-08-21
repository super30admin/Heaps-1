//APPROACH: max-heap
//time complexity O(nlogn + k)
//space complexity O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        int result = 0;
        for(int i = 0; i < k; i++){
            result = pq.poll();
        }
        return result;
    }
}

//APPROACH : min-heap
//time complexity O(nlog k)
//space complexity O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            } else {
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
