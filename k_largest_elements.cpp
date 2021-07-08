// Time Complexity : O(n * logn)
// Space Complexity :  O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
        int cap = k;
        
        for(int i = 0; i < nums.size(); i++)
        {
            pq.push(nums[i]);
            
            if(pq.size() > cap)
                pq.pop();
        }
        
        return pq.top();
    }
};