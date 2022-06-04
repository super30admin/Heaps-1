// Time Complexity :nLogk
// Space Complexity :k
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we are making minHeap of k size , first we'll insert k elements, then we'll insert one element and remove
//top one as that will be minimum and is surely not going to be our result. at the end, kth largest 
//element will be at top of the minHeap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            pq.add(nums[i]);
            pq.poll();
        }
        return pq.peek();

    }
}

// -----------USING MAX HEAP-------------------
// Time Complexity :nLog(n-k)
// Space Complexity :n-k
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we'll make priorityQueue of size n-k to store all elements smaller than kth
// largest element,
// then we'll insert next elements and take minimum of the k elements that will
// be polled as it is a max
// heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int n = nums.length;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n - k; i++) {
            pq.add(nums[i]);
        }
        for (int i = n - k; i < nums.length; i++) {
            pq.add(nums[i]);
            max = Math.min(pq.poll(), max);
        }
        return max;

    }
}