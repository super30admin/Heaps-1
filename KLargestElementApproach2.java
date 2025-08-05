
//previously we saw the implementation using min heap, however same problem can we solved using max heap as well.
//keep the size of heap to n - k
//create a max heap and add elements, the moment the size is greater than n - k, remove an element.
//this removed element would be the max element captured so far
//store it in a variable(min)
//at each iteration update min, the end result would be stored in min.

// Time Complexity : O(n log (n - k))
// Space Complexity : O(n - k)
// Did this code successfully run on Leetcode : yes

class kLargestElementInArray{
    public Integer findKLargest(int[] nums, int k){

        //max heap
        PriorityQueue<Integer> topk = new PriorityQueue<>((a, b) -> b - a);

        int min = Integer.MAX_VALUE;

        int n = nums.length;

        for (int i : nums){
            topk.add(i);
            if (topk.size() > n - k){
                min = Math.min(min, topk.poll());
            }
        }

        return min;

    }
}