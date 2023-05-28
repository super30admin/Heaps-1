// TC: O(nlogk)
// SC:O(K)

// Approach:
// We require the kth largest element , So I used Min Heap , By traversing each element in the array and pushed in to heap,
// If size exceeds k i.e size>k then I popped the element.
// After completion of traversal kth  largest element will be on the top 

// Problem faced:
// I checked the size and popped before pushing it is not the correct procedure



class Solution {
    public int findKthLargest(int[] nums, int k) {

// Min heap
    PriorityQueue<Integer>pq=new PriorityQueue<>();

    for(int i=0;i<nums.length;i++)
    {
        // Be careful this step should be before than checking size
        pq.add(nums[i]);

        if(pq.size()>k)
        {
          pq.poll();
        }    
    }
    return pq.peek();
        
    }
}