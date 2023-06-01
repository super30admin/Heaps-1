// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we take a min heap of size k, we keep on inserting all elements in to the heap, while also checking if size is > k, we pop the element;
// finally, we return the top element of the heap.

class Solution {
public:
    class mycomparator{
        public:
        bool operator()(int a, int b)
        {
            return a > b;
        }
    };
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,mycomparator>pq;
        for(int i = 0;i<nums.size();i++)
        {
            pq.push(nums[i]);
            if(pq.size()>k)
            {
                pq.pop();
            }
        }
        return pq.top();
    }
};