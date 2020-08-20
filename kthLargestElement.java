//Brute Force Solution: sort the array and then find the kth last element
//time complexity : O(nlogn)
//space complexity : O(1)
/**
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int i=nums.length-1;
        int target = nums.length-k;
        while(i!=target) i--;
        return nums[i];      
    }
}
**/
//using min heap
//time complexity: O(nlogk) where k is the size of heap
//space complexity : O(k) where k is the size of the heap
/**
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        while(i<nums.length)
        {
            if(pq.size()<k) pq.add(nums[i]);
            else
            {   
                pq.add(nums[i]);
                pq.poll();
            }
            i++;
        }
        return pq.peek();
        
    }
}
**/

//using max heap
//time complexity : O(nlogk) where k is the heap size
//space complexity: O(k) where k is the size of heap
//approach: we first multiple each element in array wiht -1, then create a max heap
// if heap size< k, add the incoming element
// else add the incoming element to the heap and then poll() it.


class Solution {
    public int findKthLargest(int[] nums, int k) {
        for(int i=0;i<nums.length;++i) nums[i]*=-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;++i)
        {
            pq.add(nums[i]);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek()*-1;
    }
}