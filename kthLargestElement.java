// Approach 1: Using min heap
// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We will use a min heap of size k and keep inserting elements
// When we insert elements if size exceeds k, we remove min element
// When we are done traversing the array, the root will now have kth largest element

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}

// Approach 2: Using max heap
// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Similar to Approach 1 but we will use a maxheap of size n-k

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i:nums){
            pq.add(i);
            if(pq.size()>(n+1-k))
                pq.poll();
        }
        return pq.peek();
    }
}

// Approach 3: Quick select
// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can use quicksort, while sorting in descending order
// When we find partition index, we compare it with k and accordingly do quicksort on corresponding half
// We recurse till partition index = k-1

class Solution {
    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int pIdx = low;
        for(int i=low;i<=high-1;i++){
            if(arr[i] > pivot){
                int temp = arr[i];
                arr[i] = arr[pIdx];
                arr[pIdx] = temp;
                pIdx++;
            }
        }
        int temp = arr[pIdx];
        arr[pIdx] = arr[high];
        arr[high] = temp;
        return pIdx;
    }
    private int quickSelect(int[] arr, int low, int high, int k){
            int pIdx = partition(arr, low, high);
            if(pIdx == k-1)
                return arr[pIdx];
            else if(pIdx > k-1)
                return quickSelect(arr, low, pIdx-1, k);
            else
                return quickSelect(arr, pIdx+1, high, k);
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
}
