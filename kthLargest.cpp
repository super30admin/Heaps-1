// Time Complexity : O(n); n = size of array
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create a max-heap and add all elements of array in it
// 2. Pop k-1 elements out of it and return the kth element as result

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq(nums.begin(), nums.end());
        while(k>1){
            pq.pop();
            k--;
        }
        return pq.top();
    }
};