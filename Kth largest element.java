// Time Complexity: O(nlogk)
// Space Complexity: O(n)
// Did this code run on Leetcode: Yes
// Any problem you faced while codeing this : No
// Your code here along with comments explaining your approach
//  Using Max Heap: The size of the heap we will take here is (n-k) and store the max element(top most) elements in a result variable. 
// Everytime before a value is added to the result variable, we will find the minimum amongst the existing one and the new one. 
// There will be k attempts to add a value in the result as there are n elements and k-n in the heap.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a); //Max Heap using custom comparator

        int n=nums.length;
        int result=Integer.MAX_VALUE; //assign result with max value
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);    //add the current element to the heap
            if(pq.size()>n-k)   //when the size of the heap>n-k
            {
                result=Math.min(pq.poll(),result); //pop the max element and compare it with the existing result. Minimum amongst them will be the kth largest element
            }
        }
        return result;
    }
}

//Using Max Heap: The size of the heap we will take here is (n-k) and store the max element(top most) elements in a result variable. Everytime before a value is added to the result variable, we will find the minimum amongst the existing one and the new one. There will be k attempts to add a value in the result as there are n elements and k-n in the heap.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a); //Max Heap using custom comparator

        int n=nums.length;
        int result=Integer.MAX_VALUE; //assign result with max value
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);    //add the current element to the heap
            if(pq.size()>n-k)   //when the size of the heap>n-k
            {
                result=Math.min(pq.poll(),result); //pop the max element and compare it with the existing result. Minimum amongst them will be the kth largest element
            }
        }
        return result;
    }
}
