// Time Complexity :O(nlogk) n is the total elememnts
// Space Complexity : O(k) k-> Size of the heap  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int>> pq;
        for(auto num : nums){
            pq.push(num);
            if(pq.size() > k){
                pq.pop();
            }
        }
        
        return pq.top();
    }
};