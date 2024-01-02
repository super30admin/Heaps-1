//  Time Complexity: O(n * log k)
//  Space Complexity: O(k)
// Using Min Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele: nums){
            if(pq.size() < k){
                pq.add(ele);
            }else if(pq.peek() < ele){
                pq.poll();
                pq.add(ele);
            }
        }
        return pq.peek();
    }
}

//  Time Complexity: O(n * log (n - k))
//  Space Complexity: O(n - k)
// Using Max Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length - k;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;

        for(int ele:nums){
            pq.add(ele);
            if(pq.size() > size){
                result = Math.min(pq.poll(), result);

            }
        }
        return result;
    }
}


//  Time Complexity: Average O(n)
//  Space Complexity: O(1)
// Using Quick Select
class Solution {
    public int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];
        int i = lo, j = hi+1;
        while(true){
            while(i < hi && nums[++i] > pivot);
            while(j > lo && nums[--j] < pivot);
            if(i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
        }
        int temp = nums[j];
        nums[j] = nums[lo];
        nums[lo] = temp;
        return j;
    }
    
    
    public int findKthLargest(int[] nums, int k) {
        // This approach is using Quick sort algorithm
        int lo = 0, hi = nums.length -1;
        while(lo < hi){
            int j = partition(nums, lo, hi);
            if(j < k-1) lo = j+1;
            else if(j>k-1) hi = j-1;
            else return nums[k-1];
        }
        return nums[k-1];
    }
}